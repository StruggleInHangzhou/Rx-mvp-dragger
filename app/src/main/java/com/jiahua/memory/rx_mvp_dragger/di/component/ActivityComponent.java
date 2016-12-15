package com.jiahua.memory.rx_mvp_dragger.di.component;

import android.support.v7.app.AppCompatActivity;

import com.jiahua.memory.rx_mvp_dragger.MainActivity;
import com.jiahua.memory.rx_mvp_dragger.di.ActivityScope;
import com.jiahua.memory.rx_mvp_dragger.di.moudle.ActivityModule;

import dagger.Component;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：ActivityComponent
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent
{
    AppCompatActivity getActivity();

    void inject(MainActivity mainActivity);
}
