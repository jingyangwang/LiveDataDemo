package com.viewmodel;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangjingyang.myapplication.R;

public class TestFragment extends Fragment {
     static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;
    View view;
    String userId;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //通过Arguments获取uid
         userId = getArguments().getString(TestFragment.UID_KEY);
         Log.i("debug2121ads223rf3g","userId "+userId);
        //创建ViewModel，不必太在意ViewModel的创建形式，这个之后会做详细的分析。现在只需要明白是在哪里生成的就行。
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        viewModel.init(userId);
    }

    TextView test_tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout1, container, false);
         test_tv=view.findViewById(R.id.test_view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("debug2121ads223rf3g","userId "+userId);
//        test_tv.setText(userId);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
