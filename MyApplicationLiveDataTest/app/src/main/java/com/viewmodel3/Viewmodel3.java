package com.viewmodel3;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;
//定义两个数据的变量
public class Viewmodel3 extends ViewModel {
    private MutableLiveData<String> mutableLiveDataString;
    private MutableLiveData<List<String>> listMutableLiveData;

    public MutableLiveData<String> getMutableLiveDataString() {
        if(mutableLiveDataString==null){
            mutableLiveDataString=new MutableLiveData<>();
        }
        return mutableLiveDataString;
    }

    public MutableLiveData<List<String>> getListMutableLiveData() {
        if(listMutableLiveData==null){
            listMutableLiveData=new MutableLiveData<>();
        }
        return listMutableLiveData;
    }



}
