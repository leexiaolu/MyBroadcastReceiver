package com.example.leesnriud.mybroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android broadcastreceiver
 * <p>
 * 标准广播 完全异步执行的广播，发出广播后，所有的广播接收器会在同一时刻接收到这条广播
 * 有序广播 同步执行的一种广播，发出广播后，同一时间只有一个广播接收器可以收到，只有在当前广播接收器的逻辑执行完之后才会被下一个广播接收器收到
 * <p>
 * 动态注册 通过java代码 需要注意一定要在onDestroy方法中取消广播
 * 静态注册 在androidmanifest文件中注册
 * <p>
 * 标准广播 sendbroadcast(intent)
 * 有序广播 sendorderedbroadcast(intent,null)
 * 可以在清单文件中的intent-filter通过:android:priority="100"设置优先级。范围-1000 ~  1000 之间
 * 值越大优先级越高
 */
public class MainActivity extends BaseActivity {

    MyBRReceiver myBRReceiver;
    private MyBRReceiver3 localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myBRReceiver = new MyBRReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myBRReceiver, intentFilter);

        //模拟别处登录
        //初始化广播接收者，设置过滤器
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localReceiver = new MyBRReceiver3();
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.leesnriud.mybroadcastreceiver.MY_LOGIN_OTHER");
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBRReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    @OnClick({R.id.bt_send, R.id.bt_login, R.id.bt_unlogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_send:
                sendBroadcast(new Intent("com.example.leesnriud.mybroadcastreceiver.MY_BRRECEIVER2"));
                break;
            case R.id.bt_login:
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_unlogin:
                Intent intent1 = new Intent("com.example.leesnriud.mybroadcastreceiver.MY_LOGIN_OTHER");
                localBroadcastManager.sendBroadcast(intent1);
                break;
        }
    }
}
