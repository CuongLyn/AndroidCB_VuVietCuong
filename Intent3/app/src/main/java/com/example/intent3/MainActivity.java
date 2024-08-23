package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.inappmessaging.model.Button;

public class MainActivity extends AppCompatActivity {
    EditText edt_data, edt_kq;
    View btn_yckq;
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
        edt_kq = findViewById(R.id.edt_kq);
        edt_data = findViewById(R.id.edt_data);
        btn_yckq = findViewById(R.id.btn_yckq);
        //Xử lý sự kiện
        btn_yckq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khai báo intent
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                //Lấy dữ liệu từ edt_data
                int a = Integer.parseInt(edt_data.getText().toString());
                //Đưa giữ liệu vào intent
                myintent.putExtra("data", a);
                //Khởi động intent
                startActivityForResult(myintent, 99);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33){
            int kq = data.getIntExtra("kq", 0);
            edt_kq.setText("Giá trị gốc là: "+kq);
        }
        if(requestCode == 99 && resultCode == 34){
            int kq = data.getIntExtra("kq", 0);
            edt_kq.setText("Giá trị bình phương là: "+kq);
        }
    }
}