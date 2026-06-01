package vn.edu.tinhoc123.hethongquanlysanbong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ManHinhChinhActivity extends AppCompatActivity {

    private CardView btnMenuLichDat, btnMenuSanBong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);

        btnMenuLichDat = findViewById(R.id.btnMenuLichDat);
        btnMenuSanBong = findViewById(R.id.btnMenuSanBong);

        if (btnMenuLichDat != null) {
            btnMenuLichDat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ManHinhChinhActivity.this, LichDatSanActivity.class);
                    startActivity(intent);
                }
            });
        }

        if (btnMenuSanBong != null) {
            btnMenuSanBong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ManHinhChinhActivity.this, DanhSachSanActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}