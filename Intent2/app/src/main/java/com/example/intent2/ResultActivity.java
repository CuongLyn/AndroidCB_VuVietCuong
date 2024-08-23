package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView txt_nghiem;
    Button btn_back;
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
        txt_nghiem = findViewById(R.id.txt_nghiem);
        btn_back = findViewById(R.id.btn_back);
        //Nhận Intent
        Intent myintent = getIntent();
        //Lấy bundle ra khỏi intent
        Bundle mybundle = myintent.getBundleExtra("mypackage");
        //Lấy dữ liệu khỏi bundle
        int a = mybundle.getInt("soa");
        int b = mybundle.getInt("sob");
        //Giải phương trình bậc nhất
        String nghiem = "";
        if(a == 0 && b == 0){
            nghiem = "PT vô số nghiệm";
        }
        else if(a == 0 && b != 0){
            nghiem = "PT vô nghiệm";
        }
        else{
            nghiem = "Nghiệm PT =" + (-1.0*b)/a;
        }
        txt_nghiem.setText(nghiem);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}