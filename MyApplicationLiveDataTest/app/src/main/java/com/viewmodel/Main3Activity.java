package com.viewmodel;

import android.app.FragmentTransaction;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.wangjingyang.myapplication.R;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    MutableLiveData<List<User>> users;

//https://www.cnblogs.com/zqlxtt/p/6888507.html

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        frameLayout = findViewById(R.id.framelayout);

//        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);
//        model.getUsers().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(@Nullable List<User> users) {
//
//            }
//        });

        initFragment();
    }

    private  void initFragment(){
        TestFragment testFragment = new TestFragment();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        Bundle bundle =new Bundle();
        bundle.putString(TestFragment.UID_KEY,"UID_KEY_Test");
        testFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.framelayout, testFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }




}
