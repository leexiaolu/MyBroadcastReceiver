package com.example.leesnriud.mybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by lee.snriud on 2018/3/13.
 */

public class MyBRReceiver1 extends BroadcastReceiver{

    private final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_BOOT.equals(intent.getAction()))
            Toast.makeText(context, "开机完成了", Toast.LENGTH_LONG).show();
    }
}
