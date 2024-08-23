package com.example.sqlite1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt_malop, edt_tenlop, edt_siso;
    Button btn_insert, btn_delete, btn_update, btn_query;
    //Khai báo listview
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;
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
        edt_malop = findViewById(R.id.edt_malop);
        edt_tenlop = findViewById(R.id.edt_tenlop);
        edt_siso = findViewById(R.id.edt_siso);
        btn_insert = findViewById(R.id.btn_insert);
        btn_delete = findViewById(R.id.btn_delete);
        btn_update = findViewById(R.id.btn_update);
        btn_query = findViewById(R.id.btn_query);
        //Tạo listView
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);
        //Tạo và mở cơ sở dữ liệu SQLite
        mydatabase = openOrCreateDatabase("qlsv.db", MODE_PRIVATE,null);
        //Tạo table để chứa dữ liệu
        try{
            String sql = "CREATE TABLE tbllop(malop TEXT primary key, tenlop TEXT, siso INTEGER)";
            mydatabase.execSQL(sql);
        }
        catch (Exception e){
            Log.e("Eror", "Table đã tồn tại");
        }
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edt_malop.getText().toString();
                String tenlop = edt_tenlop.getText().toString();
                int siso = Integer.parseInt(edt_siso.getText().toString());
                ContentValues myvalue = new ContentValues();
                myvalue.put("malop", malop);
                myvalue.put("tenlop", tenlop);
                myvalue.put("siso", siso);
                String msg = "";
                if(mydatabase.insert("tbllop", null, myvalue) == -1){
                    msg = "Fail to insert record";
                }
                else{
                    msg = "Insert record Sucessfully";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edt_malop.getText().toString();
                int n = mydatabase.delete("tbllop", "malop = ?", new String[]{malop});
                String msg = "";
                if(n == 0){
                    msg = "NO record to Delete";
                }
                else{
                    msg = n + "record is deleted";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int siso = Integer.parseInt(edt_siso.getText().toString());
                String malop = edt_malop.getText().toString();
                ContentValues myvalues = new ContentValues();
                myvalues.put("siso", siso);
                int n = mydatabase.update("tbllop", myvalues, "malop = ?", new String[]{malop});
                String msg = "";
                if(n == 0){
                    msg = "No record is Update";
                }
                else{
                    msg = n + "record is Updated";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist.clear();
                Cursor c= mydatabase.query("tbllop", null, null, null, null, null, null);
                c.moveToNext();
                String data = "";
                while(c.isAfterLast() == false){
                    data = c.getString(0)+" - "+c.getString(1)+" - "+c.getString(2);
                    c.moveToNext();
                    mylist.add(data);
                }
                c.close();
                myadapter.notifyDataSetChanged();
            }
        });
    }
}