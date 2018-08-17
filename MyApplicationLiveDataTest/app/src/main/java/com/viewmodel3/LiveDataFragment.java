package com.viewmodel3;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wangjingyang.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class LiveDataFragment extends Fragment {
    Viewmodel3 viewmodel3;
    TextView tv1,tv2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_data, container, false);
        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);
        tv1.setOnClickListener(listener);
        tv2.setOnClickListener(listener);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewmodel3 = ViewModelProviders.of(this).get(Viewmodel3.class);

        viewmodel3.getListMutableLiveData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> list) {
                Toast.makeText(getContext(),"列表刷新",Toast.LENGTH_LONG).show();
            }
        });

        viewmodel3.getMutableLiveDataString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(getContext(),"String刷新",Toast.LENGTH_LONG).show();

            }
        });



    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv1:
                    List<String> list=new ArrayList<>();
                    list.add("list 的更改值 tv1");
                     viewmodel3.getListMutableLiveData().setValue(list);

                    break;
                case R.id.tv2:
                    viewmodel3.getMutableLiveDataString().setValue("String 的更改值  tv2");

                    break;

            }


        }
    };


}
