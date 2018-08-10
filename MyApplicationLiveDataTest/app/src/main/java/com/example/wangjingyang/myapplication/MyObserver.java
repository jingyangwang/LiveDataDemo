package com.example.wangjingyang.myapplication;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {
@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {

    }
}

