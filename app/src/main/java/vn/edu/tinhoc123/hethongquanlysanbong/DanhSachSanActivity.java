package vn.edu.tinhoc123.hethongquanlysanbong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

public class DanhSachSanActivity extends AppCompatActivity {

    private ListView lvDanhSachSan;
    private ArrayList<String> dsSanBong;
    private ArrayAdapter<String> adapter;
    private TextView txtSanTrongNum;
    private TextView txtDonHuyNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_san);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvDanhSachSan = findViewById(R.id.lvDanhSachSan);
        txtSanTrongNum = findViewById(R.id.txtSanTrongNum);
        txtDonHuyNum = findViewById(R.id.txtDonHuyNum);

        dsSanBong = new ArrayList<>();
        dsSanBong.add("⚽ Sân 5 người - Sân NTU 1 (Còn trống)");
        dsSanBong.add("⚽ Sân 5 người - Sân NTU 2 (Đã đặt)");
        dsSanBong.add("⚽ Sân 5 người - Sân NTU 3 (Còn trống)");
        dsSanBong.add("⚽ Sân 5 người - Sân NTU 4 (Đã đặt)");
        dsSanBong.add("⚽ Sân 7 người - Sân NTU 5 (Còn trống)");
        dsSanBong.add("⚽ Sân 7 người - Sân NTU 6 (Đã đặt)");
        dsSanBong.add("⚽ Sân 7 người - Sân NTU 7 (Còn trống)");
        dsSanBong.add("⚽ Sân 7 người - Sân NTU 8 (Đã đặt)");
        dsSanBong.add("⚽ Sân 11 người - Sân NTU 9 (Còn trống)");
        dsSanBong.add("⚽ Sân 11 người - Sân NTU 10 (Đã đặt)");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsSanBong);
        if (lvDanhSachSan != null) {
            lvDanhSachSan.setAdapter(adapter);
        }

        tinhToanTrangThaiSan();

        if (lvDanhSachSan != null) {
            lvDanhSachSan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String sanDuocChon = dsSanBong.get(position);

                    if (sanDuocChon.contains("(Đã đặt)")) {
                        Toast.makeText(DanhSachSanActivity.this, "Sân này đã có người đặt! Vui lòng chọn sân trống.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent intent = new Intent(DanhSachSanActivity.this, ChiTietDatSanActivity.class);
                    intent.putExtra("TEN_SAN", sanDuocChon);
                    startActivity(intent);
                }
            });
        }
    }

    private void tinhToanTrangThaiSan() {
        int soSanTrong = 0;
        int soSanDaDat = 0;

        for (String san : dsSanBong) {
            if (san.contains("(Còn trống)")) {
                soSanTrong++;
            } else {
                soSanDaDat++;
            }
        }

        if (txtSanTrongNum != null) {
            txtSanTrongNum.setText(String.valueOf(soSanTrong));
        }
        if (txtDonHuyNum != null) {
            txtDonHuyNum.setText(String.valueOf(soSanDaDat));
        }
    }
}