/*
 * Copyright (C) 2017, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * App.java
 *
 * 
 *
 * Author huanghaiqi, Created at 2017-01-05
 *
 * Ver 1.0, 2017-01-05, huanghaiqi, Create file.
 */

package com.halohoop.leakcanarydemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class App extends Application {

    private SingleInstance instance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
        instance = SingleInstance.getInstance();
    }
}
