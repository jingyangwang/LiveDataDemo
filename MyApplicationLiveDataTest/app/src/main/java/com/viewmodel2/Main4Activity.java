package com.viewmodel2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wangjingyang.myapplication.R;
import com.viewmodel.TestFragment;

public class Main4Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initFragment();


    }

    public void initFragment() {
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
