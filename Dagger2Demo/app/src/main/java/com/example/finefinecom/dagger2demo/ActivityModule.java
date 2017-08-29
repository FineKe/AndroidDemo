package com.example.finefinecom.dagger2demo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by finefine.com on 2017/8/29.
 */

@Module
public class ActivityModule {
    private MainActivity mainActivity;

    public ActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    public MainActivity getMainActivity() {
        return mainActivity;
    }

    @Provides
    public User providerUser()
    {
        return new User("user from ActivityModule");
    }

    @Provides
    public DaggerPresenter providerDaggerPresenter(MainActivity activity,User user)
    {
        return new DaggerPresenter(activity,user);
    }

}
