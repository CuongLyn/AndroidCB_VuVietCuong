package com.example.intent2;

import android.content.Intent;
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
    EditText edtA, edtB;
    Button btnKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnKQ = findViewById(R.id.btnKQ);
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khai báo intent
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                //Lấy dữ liệu
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                //Đóng gói dữ liệu trong Bundle
                Bundle mybundle = new Bundle();
                //Đưa dữ liệu vào bundle
                mybundle.putInt("soa", a);
                mybundle.putInt("sob", b);
                // Đưa bundle vào intent
                myintent.putExtra("mypackage", mybundle);
                //Khởi động intent
                startActivity(myintent);
            }
        });
    }
}