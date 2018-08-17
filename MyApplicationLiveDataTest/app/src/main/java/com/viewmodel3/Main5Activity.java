package com.viewmodel3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wangjingyang.myapplication.R;
import com.viewmodel2.TestFeragment2;

public class Main5Activity extends AppCompatActivity {


    /*
    * LiveData使用
 在了解LiveData定义和优点后，那它到底怎么应用呢？LiveData有几种使用方式：

  使用LiveData对象
继承LiveData类
使用LiveData对象
  使用LiveData对象主要有以下几个步骤：

创建保存特定数据类型的LiveData实例；
创建Observer对象，作为参数传入LiveData.observe()方法添加观察者；
更新Livedata对象存储的数据；
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        initFragment();
    }


    public  void  initFragment(){
        LiveDataFragment liveDataFragment=new LiveDataFragment();
        FragmentManager mFragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,liveDataFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }


    public void initFragment1() {
        TestFeragment2 testFeragment2 = new TestFeragment2();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(testFeragment2.UID_KEY, "UID_KEY_Test");
        testFeragment2.setArguments(bundle);
        fragmentTransaction.replace(R.id.framelayout, testFeragment2);
        fragmentTransaction.commitAllowingStateLoss();
    }

}
