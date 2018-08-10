package com.example.wangjingyang.myapplication;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

public class MyData extends MutableLiveData<String> {

    private final String TAG = "LiveData";

    private int count = 0;
    private boolean RUN = true;

    private LongTimeWork mThread = new LongTimeWork();

    public MyData() {
        mThread.start();


    }

    @Override
    protected void onActive() {
        super.onActive();
        Log.d(TAG, "onActive");

        RUN = true;
        mThread.interrupt();

    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.d(TAG, "onInactive");

        RUN = false;

    }



        private class LongTimeWork extends Thread {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (!RUN) {
                            Thread.sleep(Long.MAX_VALUE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    count++;
                    postValue(String.valueOf(count));

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
