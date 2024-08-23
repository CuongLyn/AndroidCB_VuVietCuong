package com.example.thuchanh1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen, edtCCCD, edtBosung;
    Button btnGuiTT;
    RadioGroup idgroup;
    CheckBox chkDocBao, chkDocSach, chkCoding;

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
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCCCD = findViewById(R.id.edtCCCD);
        edtBosung = findViewById(R.id.edtBoSung);
        btnGuiTT = findViewById(R.id.btnGuiTT);
        idgroup = findViewById(R.id.idgroup);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkDocBao = findViewById(R.id.chkDocBao);
        chkCoding = findViewById(R.id.chkCoding);
        //Xử lý vào btnGuiTT
        btnGuiTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lấy thông tin họ tên
                String hoTen = edtHoTen.getText().toString();
                if(hoTen.length() < 3){
                    Toast.makeText(MainActivity.this, "Họ Tên phải lớn hơn 3 ký tự", Toast.LENGTH_LONG).show();
                    edtHoTen.requestFocus();
                    edtHoTen.selectAll();
                    return;
                }
                //Lấy thông tin CCCD
                String cccd = edtCCCD.getText().toString();
                if(cccd.length() != 9){
                    Toast.makeText(MainActivity.this, "CCCD phải đủ 9 số", Toast.LENGTH_SHORT).show();
                    edtCCCD.requestFocus();
                    edtCCCD.selectAll();
                    return;
                }
                //Lấy thông tin Bằng cấp
                int idselect = idgroup.getCheckedRadioButtonId();
                RadioButton rdaselect = findViewById(idselect);
                String bangCap = rdaselect.getText().toString();
                //Lấy thông tin Sở thích
                String soThich = "";
                if(chkDocSach.isChecked()){
                    soThich += chkDocSach.getText().toString()+"-";
                }
                if(chkDocBao.isChecked()){
                    soThich += chkDocBao.getText().toString() + "-";
                }
                if(chkCoding.isChecked()){
                    soThich += chkCoding.getText().toString();
                }
                //Lấy thông tin Bổ sung
                String boSung = edtBosung.getText().toString();
                String tongHop = hoTen+"\n"+cccd+"\n"+bangCap+"\n"+soThich+"\n";
                        tongHop +="------------Thông Tin Bổ Sung--------------\n";
                        tongHop += boSung+"\n";
                        tongHop +="----------------------------------------------------------";
                //Tạo Dialog và hiển thị thông tin tổng hợp lên
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                        myDialog.setTitle("THÔNG TIN CÁ NHÂN");
                        myDialog.setMessage(tongHop);
                        myDialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        myDialog.create().show();
            }
        });
    }
}