package com.viewmodel;

import android.arch.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {
    private User user;
    private  String userId;

    //初始化传递uid进来
    public void init(String userId) {
        this.userId = userId;
    }
    //提供完整的用户信息
    public User getUser() {
        return user;
    }


}
