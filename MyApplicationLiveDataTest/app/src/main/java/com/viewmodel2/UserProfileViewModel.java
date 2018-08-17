package com.viewmodel2;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class UserProfileViewModel extends ViewModel {

    //private User user;
    private LiveData<User> user;
    public LiveData<User> getUser() {

        final MutableLiveData<User> user = new MutableLiveData<>();
        User user1=new User();
        user1.setUseId(1);
        user1.setUseName("name1");
        user.setValue(user1);

        return user;
    }

    public void  test(){
        Log.i("debug3232332322","test   ");
        getUser();
    }


    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<String>();
        }
        return mCurrentName;
    }


}
