package com.example.intent3;

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

public class ResultActivity extends AppCompatActivity {
    EditText edt_nhan;
    Button btn_guigoc, btn_guibinhphuong;
    Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edt_nhan = findViewById(R.id.edt_nhan);
        btn_guigoc = findViewById(R.id.btn_guigoc);
        btn_guibinhphuong = findViewById(R.id.btn_guibinhphuong);
        //Nhận intent
        myintent = getIntent();
        //Lấy dữ liệu ra khỏi intent
        int a = myintent.getIntExtra("data", 0);
        edt_nhan.setText(a+"");
        btn_guigoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintent.putExtra("kq", a);
                setResult(33, myintent);
                finish();
            }
        });
        btn_guibinhphuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintent.putExtra("kq", a*a);
                setResult(34, myintent);
                finish();
            }
        });
    }
}