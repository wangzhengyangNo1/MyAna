package com.wzhy.myana;

import android.app.Application;
import android.content.Context;

/**
 * Created by techfit on 2017/2/20.
 */

public class AppAna extends Application {

    private static AppAna mApp;

    public static AppAna getApp(){
        return mApp;
    }

    public  static Context getAppContext(){
        return mApp.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }
}