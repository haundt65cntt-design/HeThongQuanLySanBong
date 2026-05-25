package vn.edu.tinhoc123.hethongquanlysanbong;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ManHinhChinhActivity extends AppCompatActivity {

    private ListView lvSanBong;
    private ArrayList<String> dsSanBong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);

        lvSanBong = findViewById(R.id.lvSanBong);


        dsSanBong = new ArrayList<>();
        dsSanBong.add("Sân 5 người - Sân cỏ nhân tạo NTU - Sân 1 (Giá: 200k/h)");
        dsSanBong.add("Sân 5 người - Sân cỏ nhân tạo NTU - Sân 2(Giá: 200k/h)");
        dsSanBong.add("Sân 7 người - Sân cỏ nhân tạo NTU - Sân 3 (Giá: 350k/h)");
        dsSanBong.add("Sân 7 người - Sân cỏ nhân tạo NTU - Sân 4 (Giá: 350k/h)");
        dsSanBong.add("Sân 11 người - Sân cỏ nhân tạo NTU - Sân 5 (Giá: 700k/h)");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsSanBong);
        lvSanBong.setAdapter(adapter);
    }
}