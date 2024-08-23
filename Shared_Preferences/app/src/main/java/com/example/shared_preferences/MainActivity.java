package com.example.shared_preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edt_kq;
    Button btn_tong, btn_clear;
    TextView txt_lichsu;
    String lichsu = "";

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
        //Ánh xạ id
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edt_kq = findViewById(R.id.edt_kq);
        txt_lichsu = findViewById(R.id.txt_lichsu);
        btn_clear = findViewById(R.id.btn_clear);
        btn_tong = findViewById(R.id.btn_tong);
        //Đọc la dữ liệu đã lưu trong SharedPreferences
        SharedPreferences mypref = getSharedPreferences("mysave", MODE_PRIVATE);
        lichsu = mypref.getString("ls", "");
        txt_lichsu.setText(lichsu);
        btn_tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a + b;
                edt_kq.setText(c+"");
                lichsu += a + " + " + b + " = " + c;
                txt_lichsu.setText(lichsu);
                lichsu += "\n";
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lichsu ="";
                txt_lichsu.setText(lichsu);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //4 bước lưu trữ dữ liệu
        SharedPreferences mypref = getSharedPreferences("mysave", MODE_PRIVATE);
        SharedPreferences.Editor myedit = mypref.edit();
        myedit.putString("ls", lichsu);
        myedit.commit();
    }
}