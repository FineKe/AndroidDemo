package com.example.finefinecom.dagger2demo;

import dagger.Component;

/**
 * Created by finefine.com on 2017/8/29.
 */
@Component(modules = ActivityModule.class)
public interface ActivityComponet {
    void inject(MainActivity mainActivity);

}


