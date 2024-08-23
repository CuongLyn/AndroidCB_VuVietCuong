package com.example.custom_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int image[] = {R.drawable.samsung, R.drawable.iphone, R.drawable.xiaomi, R.drawable.oppo, R.drawable.htc};
    String name[] = {"Điện thoại SamSung", "Điện thoại Iphone", "Điện thoại Xiaomi", "Điện thoại Oppo", "Điện thoại HTC"};
    //Khai báo ListView
    ArrayList<phone> mylist;
    MyArrayAdapter myadapter;
    ListView lv;
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
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>(); // Tạo mới mảng rỗng
        for(int i = 0; i < name.length; i++){
            mylist.add(new phone(image[i], name[i]));
        }
        myadapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, mylist);
        lv.setAdapter(myadapter);
        //Xử lý Click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myintent = new Intent(MainActivity.this, SubActivity.class);
                myintent.putExtra("name", name[i]);
                startActivity(myintent);
            }
        });
    }
}