package com.example.gui_bai3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtTen, edtChieuCao, edtCanNang;
    private TextView txtBmi, txtChuanDoan;
    private Button btnTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtTen = findViewById(R.id.edt_ten);
        edtChieuCao = findViewById(R.id.edt_chieucao);
        edtCanNang = findViewById(R.id.edt_cannang);
        txtBmi = findViewById(R.id.txt_bmi);
        txtChuanDoan = findViewById(R.id.txt_chuandoan);
        btnTinh = findViewById(R.id.btn_Tinh);


        btnTinh.setOnClickListener(v -> {
            String ten = edtTen.getText().toString();
            if (ten.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tên", Toast.LENGTH_SHORT).show();
                return;
            }


            double chieuCao = getDoubleFromEditText(edtChieuCao);
            double canNang = getDoubleFromEditText(edtCanNang);


            if (chieuCao == 0 || canNang == 0) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ chiều cao và cân nặng", Toast.LENGTH_SHORT).show();
                return;
            }


            double bmi = tinhBMI(chieuCao, canNang);

            // Hiển thị kết quả
            txtBmi.setText(String.format("%.2f", bmi));
            txtChuanDoan.setText(chuanDoanBMI(bmi));
        });
    }


    private double getDoubleFromEditText(EditText editText) {
        String input = editText.getText().toString();
        if (!input.isEmpty()) {
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Dữ liệu không hợp lệ", Toast.LENGTH_SHORT).show();
            }
        }
        return 0;
    }


    private double tinhBMI(double chieuCao, double canNang) {

        chieuCao = chieuCao / 100;
        return canNang / (chieuCao * chieuCao);
    }


    private String chuanDoanBMI(double bmi) {
        if (bmi < 18) {
            return "Bạn gầy";
        } else if (bmi <= 24.9) {
            return "Bạn bình thường";
        } else if (bmi <= 29.9) {
            return "Bạn béo phì độ 1";
        } else if (bmi <= 34.9) {
            return "Bạn béo phì độ 2";
        } else {
            return "Bạn béo phì độ 3";
        }
    }
}