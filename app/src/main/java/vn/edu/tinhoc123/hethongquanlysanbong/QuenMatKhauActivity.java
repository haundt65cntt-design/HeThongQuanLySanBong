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

public class QuenMatKhauActivity extends AppCompatActivity {

    private EditText edtQuenUser, edtMatKhauMoi;
    private Button btnDoiMatKhau;
    private TextView tvQuayLaiLogin2;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mat_khau);

        edtQuenUser = findViewById(R.id.edtQuenUser);
        edtMatKhauMoi = findViewById(R.id.edtMatKhauMoi);
        btnDoiMatKhau = findViewById(R.id.btnDoiMatKhau);
        tvQuayLaiLogin2 = findViewById(R.id.tvQuayLaiLogin2);

        mDatabase = FirebaseDatabase.getInstance().getReference("Users");

        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtQuenUser.getText().toString().trim();
                String newPass = edtMatKhauMoi.getText().toString().trim();

                if (user.isEmpty() || newPass.isEmpty()) {
                    Toast.makeText(QuenMatKhauActivity.this, "Không được để trống thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mDatabase.child(user).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            mDatabase.child(user).child("password").setValue(newPass);
                            Toast.makeText(QuenMatKhauActivity.this, "Đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(QuenMatKhauActivity.this, "Tài khoản không tồn tại!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {}
                });
            }
        });

        tvQuayLaiLogin2.setOnClickListener(v -> finish());
    }
}