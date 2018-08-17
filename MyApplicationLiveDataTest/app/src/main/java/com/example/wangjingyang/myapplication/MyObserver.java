package com.example.wangjingyang.myapplication;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

//  因为 用 观察者模式所以一定要用这个周期监听 注解，来保证随着 组件的生命周期的变化 数据会进行加载上的变化

public class MyObserver implements LifecycleObserver {
@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {

    }
}

