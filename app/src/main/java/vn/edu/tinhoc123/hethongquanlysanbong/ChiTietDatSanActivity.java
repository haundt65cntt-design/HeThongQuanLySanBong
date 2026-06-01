package vn.edu.tinhoc123.hethongquanlysanbong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;

public class ChiTietDatSanActivity extends AppCompatActivity {

    private TextView tvTenSanDuocChon;
    private EditText edtTenNguoiDat, edtSoDienThoai;
    private Button btnXacNhanDat;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_dat_san);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Chi Tiết Đặt Sân");
        }

        tvTenSanDuocChon = findViewById(R.id.tvTenSanDuocChon);
        edtTenNguoiDat = findViewById(R.id.edtTenNguoiDat);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        btnXacNhanDat = findViewById(R.id.btnXacNhanDat);

        mDatabase = FirebaseDatabase.getInstance().getReference("DanhSachDonDat");

        String tenSan = getIntent().getStringExtra("TEN_SAN");
        if (tenSan == null || tenSan.isEmpty()) {
            tenSan = "Sân cỏ nhân tạo NTU - Sân 1";
        }
        tvTenSanDuocChon.setText("Tên Sân: " + tenSan);

        final String finalTenSan = tenSan;

        btnXacNhanDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenKhach = edtTenNguoiDat.getText().toString().trim();
                String sdt = edtSoDienThoai.getText().toString().trim();

                if (tenKhach.isEmpty() || sdt.isEmpty()) {
                    Toast.makeText(ChiTietDatSanActivity.this, "Vui lòng điền đầy đủ Họ tên và Số điện thoại!", Toast.LENGTH_SHORT).show();
                    return;
                }

                HashMap<String, Object> donHang = new HashMap<>();
                donHang.put("tenKhach", tenKhach);
                donHang.put("soDienThoai", sdt);
                donHang.put("tenSan", finalTenSan);


                donHang.put("ngayThue", "Hôm nay");
                donHang.put("khungGio", "17:30 - 19:00");
                donHang.put("tienCoc", "100.000 VNĐ");
                donHang.put("tongTien", "300.000 VNĐ");

                String maSanTuDong = "MS-" + String.valueOf(System.currentTimeMillis()).substring(8);
                donHang.put("maSan", maSanTuDong);
                donHang.put("trangThai", "Chờ xác nhận");

                String idDonHang = mDatabase.push().getKey();

                if (idDonHang != null) {
                    mDatabase.child(idDonHang).setValue(donHang)
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(ChiTietDatSanActivity.this, "Đặt sân thành công! Dữ liệu đã lưu lên Firebase.", Toast.LENGTH_LONG).show();
                                finish();
                            })
                            .addOnFailureListener(e -> {
                                Toast.makeText(ChiTietDatSanActivity.this, "Lỗi kết nối mạng: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}