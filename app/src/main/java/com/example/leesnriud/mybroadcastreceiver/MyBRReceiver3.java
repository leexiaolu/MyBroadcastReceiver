package com.example.leesnriud.mybroadcastreceiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by lee.snriud on 2018/3/15.
 */

public class MyBRReceiver3 extends BroadcastReceiver{

    @Override
    public void onReceive(final Context context, Intent intent) {

        Toast.makeText(context,"账号在别处登录，重新登录吧",Toast.LENGTH_LONG).show();
        ActivityCollector.finishAll();
        intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
