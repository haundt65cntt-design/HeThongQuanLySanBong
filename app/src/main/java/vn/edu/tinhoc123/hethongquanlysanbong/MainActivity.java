package vn.edu.tinhoc123.hethongquanlysanbong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvMoDangKy, tvMoQuenPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvMoDangKy = findViewById(R.id.tvMoDangKy);
        tvMoQuenPass = findViewById(R.id.tvMoQuenPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.equals("admin") && password.equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, ManHinhChinhActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu! (Thử lại với admin/admin)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (tvMoDangKy != null) {
            tvMoDangKy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DangKyActivity.class);
                    startActivity(intent);
                }
            });
        }

        if (tvMoQuenPass != null) {
            tvMoQuenPass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, QuenMatKhauActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}