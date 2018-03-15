package com.example.leesnriud.mybroadcastreceiver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lee.snriud on 2018/3/15.
 */

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
