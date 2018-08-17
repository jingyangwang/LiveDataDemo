package com.viewmodel4;

import android.arch.lifecycle.LiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;


//小景注释
//示例中截取的  主要是 livedata 内部调用 wifi ，由于害怕内存泄漏 所以内部采取了弱引用进行调用。
public class MyLiveData extends LiveData<Integer> {

    private static final String TAG = "MyLiveData";
    private static MyLiveData sData;
    private WeakReference<Context> mContextWeakReference;

    public static MyLiveData getInstance(Context context){
        if (sData == null){
            sData = new MyLiveData(context);
        }
        return sData;
    }

    private MyLiveData(Context context){
        mContextWeakReference = new WeakReference<>(context);
    }

    @Override
    protected void onActive() {
        super.onActive();
        registerReceiver();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        unregisterReceiver();
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);
        mContextWeakReference.get().registerReceiver(mReceiver, intentFilter);
        Log.i("debug212212211"," wifi 广播 注册");
    }

    private void unregisterReceiver() {
        mContextWeakReference.get().unregisterReceiver(mReceiver);
        Log.i("debug212212211"," wifi 广播 检测解绑");
    }


    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(TAG, "action = " + action);
            if (WifiManager.RSSI_CHANGED_ACTION.equals(action)) {
                int wifiRssi = intent.getIntExtra(WifiManager.EXTRA_NEW_RSSI, -200);
                int wifiLevel = WifiManager.calculateSignalLevel(
                        wifiRssi, 4);
                sData.setValue(wifiLevel);
            }
        }
    };




}
