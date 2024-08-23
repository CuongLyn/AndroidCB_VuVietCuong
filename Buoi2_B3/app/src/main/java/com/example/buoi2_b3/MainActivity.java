package com.example.buoi2_b3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edt_sdt, edt_sms;
    Button btn_call, btn_sms;
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
        edt_sms = findViewById(R.id.edt_sms);
        edt_sdt = findViewById(R.id.edt_sdt);
        btn_call = findViewById(R.id.btn_call);
        btn_sms = findViewById(R.id.btn_sms);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdt = edt_sdt.getText().toString();
                if(!sdt.isEmpty()){
                    if(ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CALL_PHONE) !=
                            PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                        return;
                    }
                    Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edt_sdt.getText().toString()));

                    startActivity(callintent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdt = edt_sdt.getText().toString();
                String msg = edt_sms.getText().toString();
                if(!sdt.isEmpty() && !msg.isEmpty()){
                    if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) !=
                            PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                        return;
                    }
                    Intent smsintent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+edt_sdt.getText().toString()));
                    smsintent.putExtra("sms_body", msg);

                    startActivity(smsintent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}