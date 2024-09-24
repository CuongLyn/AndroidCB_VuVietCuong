package com.example.gui_bai1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB;
    private TextView txtKq;
    private Button btnTong, btnHieu, btnTich, btnThuong, btnUcln, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);
        txtKq = findViewById(R.id.txt_kq);
        btnTong = findViewById(R.id.btn_tong);
        btnHieu = findViewById(R.id.btn_hieu);
        btnTich = findViewById(R.id.btn_tich);
        btnThuong = findViewById(R.id.btn_thuong);
        btnUcln = findViewById(R.id.btn_ucln);
        btnThoat = findViewById(R.id.btn_thoat);

        // Xử lý sự kiện cho nút tính tổng
        btnTong.setOnClickListener(v -> {
            int a = getInputA();
            int b = getInputB();
            int result = a + b;
            txtKq.setText("Tổng: " + result);
        });

        // Xử lý sự kiện cho nút tính hiệu
        btnHieu.setOnClickListener(v -> {
            int a = getInputA();
            int b = getInputB();
            int result = a - b;
            txtKq.setText("Hiệu: " + result);
        });

        // Xử lý sự kiện cho nút tính tích
        btnTich.setOnClickListener(v -> {
            int a = getInputA();
            int b = getInputB();
            int result = a * b;
            txtKq.setText("Tích: " + result);
        });

        // Xử lý sự kiện cho nút tính thương
        btnThuong.setOnClickListener(v -> {
            int a = getInputA();
            int b = getInputB();
            if (b != 0) {
                float result = (float) a / b;
                txtKq.setText("Thương: " + result);
            } else {
                txtKq.setText("Không thể chia cho 0");
            }
        });

        // Xử lý sự kiện cho nút tính Ước chung lớn nhất (UCLN)
        btnUcln.setOnClickListener(v -> {
            int a = getInputA();
            int b = getInputB();
            int result = ucln(a, b);
            txtKq.setText("Ước chung lớn nhất: " + result);
        });

        // Xử lý sự kiện cho nút thoát chương trình
        btnThoat.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }

    // Hàm lấy giá trị nhập từ EditText A
    private int getInputA() {
        String input = edtA.getText().toString();
        if (!input.isEmpty()) {
            return Integer.parseInt(input);
        } else {
            Toast.makeText(this, "Nhập số A", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    // Hàm lấy giá trị nhập từ EditText B
    private int getInputB() {
        String input = edtB.getText().toString();
        if (!input.isEmpty()) {
            return Integer.parseInt(input);
        } else {
            Toast.makeText(this, "Nhập số B", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    // Hàm tính UCLN
    private int ucln(int a, int b) {
        if (b == 0) {
            return a;
        }
        return ucln(b, a % b);
    }
}