package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
   //Khai báo đối tượng mà Service quản lý
    MediaPlayer mymusic;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //Khởi tạo đối tượng mà service quản lý và thiết lập thuộc tính
    @Override
    public void onCreate() {
        super.onCreate();
        mymusic = MediaPlayer.create(MyService.this, R.raw.mymusic);
        mymusic.setLooping(true); //Lặp đi lặp lại
    }
    //Hàm để khởi động đôi tượng service quản lý

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mymusic.isPlaying()){
            mymusic.pause();
        }
        else{
            mymusic.start();
        }
        return super.onStartCommand(intent, flags, startId);

    }
    //Hàm để dừng đối tượng mà service quản lý

    @Override
    public void onDestroy() {
        super.onDestroy();
        mymusic.stop();
    }
}