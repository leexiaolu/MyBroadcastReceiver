package com.example.leesnriud.mybroadcastreceiver;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee.snriud on 2018/3/15.
 */

public class ActivityCollector {
    private static List<Activity> activities = new ArrayList<Activity>();
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
