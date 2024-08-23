package com.example.tabselector;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    Button btn_cong;
    TabHost mytab;
    //Khai báo listView
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
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

        //Hàm xử lý giao diện
        addControl();
        addEvent();

    }

    private void addEvent() {
        btn_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a + b;
                mylist.add(a +" + "+ b + " = "+ c);//Thêm dữ liệu vào cho mảng
                myadapter.notifyDataSetChanged(); //Cập nhập lại Adapter
            }
        });
    }

    private void addControl() {
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btn_cong = findViewById(R.id.btn_cong);
        //Xử lý listView
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>(); // Tạo mới mảng
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mylist); //Tạo adapter
        lv.setAdapter(myadapter);
        //Xử lý tabhost
        mytab = findViewById(R.id.mytab);
        mytab.setup();
        //Khai báo tab con (TabSpec)
        TabHost.TabSpec spec1, spec2;
        //Ứng với mỗi tab chúng ta thực hiện 4 công việc
        //Tab1
        spec1 = mytab.newTabSpec("t1"); //Tạo mới tab
        spec1.setContent(R.id.tab1);         //Tham chiê id cho tab 1
        spec1.setIndicator("", getResources().getDrawable(R.drawable.cong)); //Thiết lập icon cho tab
        mytab.addTab(spec1); //Thêm tab1 vào tab chính
        //Tab2
        spec2 = mytab.newTabSpec("t2"); //Tạo mới tab
        spec2.setContent(R.id.tab2);         //Tham chiê id cho tab 1
        spec2.setIndicator("", getResources().getDrawable(R.drawable.lichsu)); //Thiết lập icon cho tab
        mytab.addTab(spec2); //Thêm tab1 vào tab chính
    }
}