package com.example.custom_listview;

import android.app.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<phone> {
    Activity context;
    int idlayout;
    ArrayList<phone> mylist;
    //Tạo constructor để MainActivity gọn đến và truyền các tham số vào


    public MyArrayAdapter(@NonNull Activity context, int idlayout, ArrayList<phone> mylist) {
        super(context, idlayout, mylist);
        this.context = context;
        this.idlayout = idlayout;
        this.mylist = mylist;
    }
    //Gọi hàm getview để tiến hành sắp xếp dữ liệu

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Tạo đế để chứa layout
        LayoutInflater mylacter = context.getLayoutInflater();
        //Đặt idlayout lên inflacter để tạo thành View
        convertView = mylacter.inflate(idlayout, null);
        //Lấy một phần tử trong mảng
        phone myphone = mylist.get(position);
        //Khai báo, tham chiếu id và hiển thị lên ImageView
        ImageView img_phone = convertView.findViewById(R.id.img_phone);
        img_phone.setImageResource(myphone.getImage());
        //Khai báo, tham chiếu id và hiển thị tên điện thoại lên TextView
        TextView txt_phone = convertView.findViewById(R.id.txt_phone);
        txt_phone.setText(myphone.getName());
        return convertView;

    }
}
