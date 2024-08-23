package com.example.intent4;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.Manifest;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CallPhoneAcivity extends AppCompatActivity {
    EditText edt_phone;
    Button btn_back1;
    ImageButton btn_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_call_phone_acivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edt_phone = findViewById(R.id.edt_phone);
        btn_back1 = findViewById(R.id.btn_back1);
        btn_call = findViewById(R.id.btn_call);
        //Xử lý sự kiện
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khai báo Intent ẩn
                Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edt_phone.getText().toString()));
                //Yêu cầu sự đồng ý của người dùng
                if(ActivityCompat.checkSelfPermission(CallPhoneAcivity.this, Manifest.permission.CALL_PHONE) !=
                        PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(CallPhoneAcivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(callintent);
            }
        });
        btn_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}