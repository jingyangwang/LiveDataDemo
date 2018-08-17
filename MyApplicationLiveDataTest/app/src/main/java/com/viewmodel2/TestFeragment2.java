package com.viewmodel2;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
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
import android.widget.Toast;

import com.example.wangjingyang.myapplication.R;

import me.eugeniomarletti.kotlin.metadata.shadow.metadata.ProtoBuf;

//修改viewmodel


public class TestFeragment2 extends Fragment {
    View view;
    UserProfileViewModel viewModel;
    public static final String UID_KEY = "UID_KEY_TestFragment2";

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                //update UI
                Log.i("debug3232332322", "user getUseName  " + user.getUseName() + "  user.getUseId()   " + user.getUseId());

                Toast.makeText(getContext(), "user.getUseName() " + user.getUseName(), Toast.LENGTH_LONG).show();
                viewModel.test();
            }
        });
//        网上样例
        viewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(getContext(), "getCurrentName  " + s, Toast.LENGTH_LONG).show();
            }
        });


        // 观察者 模式  分开写  和上面写法一致
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        viewModel.getCurrentName().observe(this, nameObserver);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout1, container, false);
        TextView test_tv = view.findViewById(R.id.test_tv);
        test_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String anotherName = "John Doe";
//                viewModel.getCurrentName().setValue(anotherName);
//                小景注释
//       postValue setValue 的区别  前者可在主线程子线程 都可调用，
// 官方文档说如果 model在一个方法中调用postValue总在setValue后面被调用，即时postValue写在了setValue前面，如下面
//                被调用的顺序依旧是setValue在前 postValue在后，亲测是这样。


//                博客摘录的 解释对比
                /*

                LiveData提供了两种改变数据的方法：setValue()和postValue()。区别是setValue()要在主线程中调用，
                而postValue()既可在主线程也可在子线程中调用。

                * postValue()方法通过ArchTaskExecutor实现在主线程中执行mPostValueRunnable对象中的内容，
                * 而在mPostValueRunnable中最终会调用setValue()方法来实现改变LiveData存储的数据。
                *
                *
                * */
                viewModel.getCurrentName().postValue(anotherName);
                viewModel.getCurrentName().setValue("a");


            }
        });
        return view;
    }
}
