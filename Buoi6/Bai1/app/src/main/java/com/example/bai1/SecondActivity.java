package com.example.bai1;

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

public class SecondActivity extends AppCompatActivity {


    Button btn_thuchien, btn_close;
    EditText edta, edtb;
    TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_thuchien = findViewById(R.id.btn_thuchien);
        edta = findViewById(R.id.edt_a);
        edtb = findViewById(R.id.edt_b);
        kq = findViewById(R.id.ketqua);
        btn_close = findViewById(R.id.btn_close);

        btn_thuchien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                String thuchien = getIntent().getStringExtra("thuchien");
                int c = 0;

                switch (thuchien){
                    case "cong":
                        c = a + b; break;
                    case "tru":
                        c = a - b; break;
                    case "nhan":
                        c = a * b; break;
                    case "chia":
                        if(b == 0){
                            kq.setText("Erorr!");
                            return;
                        }
                        else{
                            c = a / b; break;
                        }
                }
                kq.setText(""+c);
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}