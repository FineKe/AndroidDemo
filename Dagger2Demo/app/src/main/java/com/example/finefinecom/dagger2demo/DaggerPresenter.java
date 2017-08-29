package com.example.finefinecom.dagger2demo;

import java.security.PublicKey;

/**
 * Created by finefine.com on 2017/8/29.
 */

public class DaggerPresenter {
    MainActivity mainActivity;
    User user;

    public DaggerPresenter(MainActivity mainActivity, User user) {
        this.mainActivity = mainActivity;
        this.user = user;
    }
    public void showUserName()
    {
        mainActivity.showUserName(user.name);
    }
}
