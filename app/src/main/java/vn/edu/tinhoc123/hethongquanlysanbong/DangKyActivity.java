package vn.edu.tinhoc123.hethongquanlysanbong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DangKyActivity extends AppCompatActivity {

    private EditText edtDangKyUser, edtDangKyPass, edtDangKyRePass;
    private Button btnXacNhanDangKy;
    private TextView tvQuayLaiLogin;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        edtDangKyUser = findViewById(R.id.edtDangKyUser);
        edtDangKyPass = findViewById(R.id.edtDangKyPass);
        edtDangKyRePass = findViewById(R.id.edtDangKyRePass);
        btnXacNhanDangKy = findViewById(R.id.btnXacNhanDangKy);
        tvQuayLaiLogin = findViewById(R.id.tvQuayLaiLogin);

        mDatabase = FirebaseDatabase.getInstance().getReference("Users");

        btnXacNhanDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtDangKyUser.getText().toString().trim();
                String pass = edtDangKyPass.getText().toString().trim();
                String rePass = edtDangKyRePass.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty() || rePass.isEmpty()) {
                    Toast.makeText(DangKyActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!pass.equals(rePass)) {
                    Toast.makeText(DangKyActivity.this, "Mật khẩu nhập lại không khớp!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mDatabase.child(user).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Toast.makeText(DangKyActivity.this, "Tài khoản đã tồn tại trên hệ thống!", Toast.LENGTH_SHORT).show();
                        } else {
                            mDatabase.child(user).child("password").setValue(pass);
                            Toast.makeText(DangKyActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Toast.makeText(DangKyActivity.this, "Lỗi kết nối database!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        if (tvQuayLaiLogin != null) {
            tvQuayLaiLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}