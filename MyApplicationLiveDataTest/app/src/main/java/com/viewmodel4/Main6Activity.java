package com.viewmodel4;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.wangjingyang.myapplication.R;
import com.viewmodel3.LiveDataFragment;

public class Main6Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        initFragment();
    }


    public  void  initFragment(){
        WifiFragment wifiFragment=new WifiFragment();
        FragmentManager mFragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,wifiFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }
}

