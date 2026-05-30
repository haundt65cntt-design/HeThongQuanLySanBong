package vn.edu.tinhoc123.hethongquanlysanbong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ChiTietSanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san);

        // Ánh xạ các View từ giao diện XML
        TextView tvTen = findViewById(R.id.tvTenSanChiTiet);
        TextView tvGia = findViewById(R.id.tvGiaSanChiTiet);
        Button btnXacNhanDat = findViewById(R.id.btnXacNhanDat);

        // Điền thủ công dữ liệu hiển thị
        tvTen.setText("Sân cỏ nhân tạo NTU - Sân 1");
        tvGia.setText("Giá sân: 200.000 VND / Giờ");

        // Sự kiện bấm nút đặt sân
        btnXacNhanDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChiTietSanActivity.this, "Đặt sân thành công!", Toast.LENGTH_LONG).show();
                finish(); // Quay lại danh sách
            }
        });
    }
}