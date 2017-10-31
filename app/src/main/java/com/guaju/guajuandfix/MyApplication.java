package com.guaju.guajuandfix;

import android.app.Application;

/**
 * Created by guaju on 2017/10/27.
 */

public class MyApplication extends Application {
    public static boolean isHasPatch=false;
    public static AndFixManager andFixManager;

    @Override
    public void onCreate() {
        super.onCreate();
        andFixManager = AndFixManager.getInstance(this, "1.0");
        andFixManager.initAndFix();
        //完成AndFix初始化
    }
}
