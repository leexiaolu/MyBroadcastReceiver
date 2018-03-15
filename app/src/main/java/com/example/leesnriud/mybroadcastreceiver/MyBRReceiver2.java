package com.example.leesnriud.mybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by lee.snriud on 2018/3/13.
 */

public class MyBRReceiver2 extends BroadcastReceiver{

    private final String ACTION_BOOT = "com.example.leesnriud.mybroadcastreceiver.MY_BRRECEIVER2";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_BOOT.equals(intent.getAction()))
            Toast.makeText(context, "碰到我了。", Toast.LENGTH_LONG).show();
    }
}
