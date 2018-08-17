package com.viewmodel4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangjingyang.myapplication.R;
import com.viewmodel3.Viewmodel3;

import java.util.ArrayList;
import java.util.List;


public class WifiFragment extends Fragment {
    MyLiveData myLiveData;
    TextView tv1,tv2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLiveData=MyLiveData.getInstance(getContext());
        myLiveData .observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                Log.i("debug212212211","integer "+integer);
            }
        });
//       注这个方法与上面的不冲突 相当于另加一个 监听器 但是它会一直进行监听  ，与 myLiveData.onInactive(); myLiveData.Active(); 无关
//        只有 removeObserver才能让其停止。
//        testObserveForever();

    }


    public void testObserveForever(){
        Observer<Integer> observer =new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                Log.i("debug212212211","Integer Observer  "+integer);
            }
        };
        //这个方法一直会处于监听状态  除非 removeObserver()停止
        myLiveData.observeForever(observer);
        //停止上面的方法
//        myLiveData.removeObserver(observer);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.fragment_wifi, container, false);
        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);
        tv1.setOnClickListener(listener);
        tv2.setOnClickListener(listener);

        return view;
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv1:
                    myLiveData.onActive();

                    break;
                case R.id.tv2:
                    myLiveData.onInactive();

                    break;

            }


        }
    };



}
