package vn.edu.tinhoc123.hethongquanlysanbong;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ManHinhChinhActivity extends AppCompatActivity {

    private LinearLayout btnLichDat, btnSanBong, btnDoanhThu, btnDangXuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);

        btnLichDat = findViewById(R.id.btnMenuLichDat);
        btnSanBong = findViewById(R.id.btnMenuSanBong);
        btnDoanhThu = findViewById(R.id.btnMenuDoanhThu);
        btnDangXuat = findViewById(R.id.btnMenuDangXuat);

        btnLichDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienThiDialogChiTietHoaDon();
            }
        });

        btnSanBong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManHinhChinhActivity.this, DanhSachSanActivity.class);
                startActivity(intent);
            }
        });

        btnDoanhThu.setOnClickListener(v -> Toast.makeText(this, "Chức năng Xem doanh thu", Toast.LENGTH_SHORT).show());

        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ManHinhChinhActivity.this, "Đã đăng xuất tài khoản!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ManHinhChinhActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void hienThiDialogChiTietHoaDon() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chi tiết hóa đơn");

        LinearLayout layoutDialog = new LinearLayout(this);
        layoutDialog.setOrientation(LinearLayout.VERTICAL);
        layoutDialog.setPadding(50, 40, 50, 40);

        String noiDung = "Tên khách: Nguyễn Đức Hậu\n\n" +
                "Số điện thoại: 0987654321\n\n" +
                "Ngày thuê: 2026/05/28\n\n" +
                "Khung giờ: 17:30 - 19:00\n\n" +
                "Tên sân: Sân cỏ nhân tạo NTU - Sân 1\n\n" +
                "Tổng tiền: 300.000 VND";

        TextView tvNoiDung = new TextView(this);
        tvNoiDung.setText(noiDung);
        tvNoiDung.setTextSize(16);
        tvNoiDung.setTextColor(android.graphics.Color.BLACK);

        layoutDialog.addView(tvNoiDung);
        builder.setView(layoutDialog);

        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}