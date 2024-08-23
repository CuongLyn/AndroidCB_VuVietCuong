package com.example.chuyendoinhietdo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Khai báo các biến giao diện
    EditText edtF, edtC;
    Button btnFC, btnCF, btnclear;

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
        //Ánh xạ ID
        edtF = findViewById(R.id.edtF);
        edtC = findViewById(R.id.edtC);
        btnFC = findViewById(R.id.btnFC);
        btnCF = findViewById(R.id.btnCF);
        btnclear = findViewById(R.id.btnclear);
        //Xử lý tương tác với người dùng
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("0.00");
                int c = Integer.parseInt(edtC.getText().toString());
                double f = c * 1.8 + 32;
                edtF.setText(dcf.format(f)+"");
            }
        });
        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("0.00");
                int f = Integer.parseInt(edtF.getText().toString());
                double c = (f - 32) * 5/9;
                edtC.setText(dcf.format(c)+"");
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
}