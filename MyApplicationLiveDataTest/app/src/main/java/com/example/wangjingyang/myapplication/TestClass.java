package com.example.wangjingyang.myapplication;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import static android.arch.lifecycle.Lifecycle.State.STARTED;

public class TestClass  extends AppCompatTextView implements LifecycleObserver {
    private final String TAG = "绑定生命周期";

    private boolean enable;
    private Lifecycle lifecycle;

    private StringBuffer buf;

    public TestClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        buf = new StringBuffer();
    }

    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create() {
        if (enable) {
            buf.append(System.currentTimeMillis() + "-creat\n");
            this.setText(buf);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        if (enable) {
            buf.append(System.currentTimeMillis() + "-start\n");
            this.setText(buf);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume() {
        if (enable) {
            buf.append(System.currentTimeMillis() + "-resume\n");
            this.setText(buf);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        if (enable) {
            buf.append(System.currentTimeMillis() + "-pause\n");
            this.setText(buf);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        if (enable) {
            buf.append(System.currentTimeMillis() + "-stop\n");
            this.setText(buf);
        }
    }

    public void setLifecycleEanable(boolean b) {
        enable = b;
//        进阶用法：
//        可以在初始化MyObserver的时候将lifecycle传入，在MyObserver中进行操作时再次确认宿主的”生命周期”状态。例如宿主是Fragment，如果它的Activity处于Saved状态，此时调用回调可能引起崩溃。
        if (lifecycle.getCurrentState().isAtLeast(STARTED)) {
            //在这里做一些逻辑判断
        }
    }


}
