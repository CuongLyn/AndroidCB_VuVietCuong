package com.example.buoi2_b1;

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
    EditText edt1, edt2;
    TextView txt_kq;
    Button btn_cong, btn_tru, btn_nhan, btn_chia, btn_du;
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
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        txt_kq = findViewById(R.id.txt_kq);
        btn_cong = findViewById(R.id.btn_cong);
        btn_tru = findViewById(R.id.btn_tru);
        btn_nhan = findViewById(R.id.btn_nhan);
        btn_chia = findViewById(R.id.btn_chia);
        btn_du = findViewById(R.id.btn_du);
        btn_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edt1.getText().toString());
                int b = Integer.parseInt(edt2.getText().toString());
                int c = a + b;
                txt_kq.setText(c+" ");
            }
        });
        btn_tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edt1.getText().toString());
                int b = Integer.parseInt(edt2.getText().toString());
                int c = a - b;
                txt_kq.setText(c+" ");
            }
        });
        btn_nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edt1.getText().toString());
                int b = Integer.parseInt(edt2.getText().toString());
                int c = a * b;
                txt_kq.setText(c+" ");
            }
        });
        btn_chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edt1.getText().toString());
                int b = Integer.parseInt(edt2.getText().toString());
                if(b == 0){
                    txt_kq.setText("Loi!");
                }
                else{
                    int c = a / b;
                    txt_kq.setText(c+" ");
                }
            }
        });
        btn_du.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edt1.getText().toString());
                int b = Integer.parseInt(edt2.getText().toString());
                if(b == 0){
                    txt_kq.setText("Loi!");
                }
                else{
                    int c = a % b;
                    txt_kq.setText(c+" ");
                }
            }
        });
    }
}