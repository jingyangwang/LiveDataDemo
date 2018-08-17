package com.example.wangjingyang.myapplication;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;

//public class MainActivity extends AppCompatActivity {
//public class MainActivity extends AppCompatActivity implements LifecycleRegistryOwner {
public class MainActivity extends AppCompatActivity implements LifecycleOwner {
    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestClass testClass = (TestClass) findViewById(R.id.test_view);
        testClass.setLifecycle(getLifecycle());

        getLifecycle().addObserver(testClass);
        testClass.setLifecycleEanable(true);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

}
