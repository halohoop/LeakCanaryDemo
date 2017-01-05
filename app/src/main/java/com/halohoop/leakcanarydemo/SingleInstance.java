/*
 * Copyright (C) 2017, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * SingleInstance.java
 *
 * 
 *
 * Author huanghaiqi, Created at 2017-01-05
 *
 * Ver 1.0, 2017-01-05, huanghaiqi, Create file.
 */

package com.halohoop.leakcanarydemo;

import android.app.Activity;
import android.util.SparseArray;

public class SingleInstance {
    private static volatile SingleInstance instance;
    private SparseArray<Activity> container = new SparseArray<Activity>();
    private int key = 0;
    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    return instance = new SingleInstance();
                }
            }
        }
        return instance;
    }

    public void addActivity(MainActivity mainActivity) {
        container.put(key++, mainActivity);
    }
}
