package com.example.sms_receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class myBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       processSms(context, intent);
    }

    private void processSms(Context context, Intent intent) {
        Bundle myBundle = intent.getExtras();
        String message = "";
        String body = "";
        String address = "";
        if(myBundle != null){
            Object[] mysms = (Object[]) myBundle.get("pdus");
            for(int i = 0; i < mysms.length; i++){
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) mysms[i]);
                body += sms.getMessageBody(); //Lay noi dung tin nhan
                address = sms.getOriginatingAddress(); //Lay so dien thoai
            }
            message = "Có 1 tin nhắn đến từ "+address+"\n"+" "+body+" vừa gửi đến.";
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}