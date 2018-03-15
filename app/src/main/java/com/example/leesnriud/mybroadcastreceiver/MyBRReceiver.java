package com.example.leesnriud.mybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by lee.snriud on 2018/3/13.
 */

public class MyBRReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"WiFi状态发生变化",Toast.LENGTH_SHORT).show();
    }
}
