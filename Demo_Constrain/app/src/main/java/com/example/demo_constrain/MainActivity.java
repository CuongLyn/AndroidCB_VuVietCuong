package com.example.demo_constrain;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Khai báo các biến giao diện tại đây
    EditText edtA, edtB, edtKQ;
    Button btnTong, btnHieu, btnTich, btnThuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Ánh xạ id cho cac biến giao diện
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        //Xử lý sự kiện (Tính Tổng)
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString()); //Lấy dữ liệu từ edtA, ép sang kiển int và gán vào a
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a + b;
                edtKQ.setText(c+"");
            }
        });
        //Xử lý sự kiện tính Hiệu
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a - b;
                edtKQ.setText(c+"");
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a * b;
                edtKQ.setText(c+"");
            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a / b;
                if(b == 0){
                    edtKQ.setText("Lỗi");
                }
                else{
                    edtKQ.setText(c+"");
                }

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}