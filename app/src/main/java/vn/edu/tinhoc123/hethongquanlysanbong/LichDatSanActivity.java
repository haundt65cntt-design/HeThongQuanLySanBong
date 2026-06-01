package vn.edu.tinhoc123.hethongquanlysanbong;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class LichDatSanActivity extends AppCompatActivity {

    private ListView lvDanhSachDonDat;
    private ArrayList<String> dsDonDat;
    private ArrayList<String> dsChiTietDonDat;
    private ArrayAdapter<String> adapter;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_dat_san);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Lịch Sử Đặt Sân");
        }

        lvDanhSachDonDat = findViewById(R.id.lvDanhSachDonDat);
        dsDonDat = new ArrayList<>();
        dsChiTietDonDat = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsDonDat);
        if (lvDanhSachDonDat != null) {
            lvDanhSachDonDat.setAdapter(adapter);
        }

        mDatabase = FirebaseDatabase.getInstance().getReference("DanhSachDonDat");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                dsDonDat.clear();
                dsChiTietDonDat.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    String tenKhach = dataSnapshot.child("tenKhach").getValue(String.class);
                    String sdt = dataSnapshot.child("soDienThoai").getValue(String.class);
                    String tenSan = dataSnapshot.child("tenSan").getValue(String.class);
                    String trangThai = dataSnapshot.child("trangThai").getValue(String.class);
                    String maSan = dataSnapshot.child("maSan").getValue(String.class);


                    String ngayThue = dataSnapshot.child("ngayThue").getValue(String.class);
                    String khungGio = dataSnapshot.child("khungGio").getValue(String.class);
                    String tienCoc = dataSnapshot.child("tienCoc").getValue(String.class);
                    String tongTien = dataSnapshot.child("tongTien").getValue(String.class);


                    if (trangThai == null) trangThai = "Chờ xác nhận";
                    if (maSan == null) maSan = "MS-OLD";
                    if (ngayThue == null) ngayThue = "Đang cập nhật";
                    if (khungGio == null) khungGio = "Đang cập nhật";
                    if (tienCoc == null) tienCoc = "0 VNĐ";
                    if (tongTien == null) tongTien = "300.000 VNĐ";


                    dsDonDat.add("[" + maSan + "] " + tenKhach + " - " + trangThai);


                    String chiTiet = "Mã sân: " + maSan + "\n\n" +
                            "Trạng thái: " + trangThai + "\n\n" +
                            "Tên khách: " + tenKhach + "\n\n" +
                            "Số điện thoại: " + sdt + "\n\n" +
                            "Tên sân: " + tenSan + "\n\n" +
                            "Ngày thuê: " + ngayThue + "\n\n" +
                            "Khung giờ: " + khungGio + "\n\n" +
                            "Tiền đã cọc: " + tienCoc + "\n\n" +
                            "Tổng tiền: " + tongTien;
                    dsChiTietDonDat.add(chiTiet);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(LichDatSanActivity.this, "Lỗi Firebase: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        if (lvDanhSachDonDat != null) {
            lvDanhSachDonDat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    hienThiChiTietHoaDon(position);
                }
            });
        }
    }

    private void hienThiChiTietHoaDon(int viTri) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chi tiết hóa đơn");

        String thongTin = dsChiTietDonDat.get(viTri);

        builder.setMessage(thongTin);
        builder.setPositiveButton("Đóng", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}