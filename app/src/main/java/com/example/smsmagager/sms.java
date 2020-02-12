package com.example.smsmagager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class sms extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object []pdus = (Object[])bundle.get("pdus");
        SmsMessage message = SmsMessage.createFromPdu((byte[])pdus[0]);
        String msg = message.getMessageBody();
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
        Toast.makeText(context,message.getOriginatingAddress(),Toast.LENGTH_LONG).show();

    }
}
