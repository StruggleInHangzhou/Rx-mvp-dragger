package com.jiahua.memory.rx_mvp_dragger.di.component;

import android.support.v7.app.AppCompatActivity;

import com.jiahua.memory.rx_mvp_dragger.di.FragmentScope;
import com.jiahua.memory.rx_mvp_dragger.di.moudle.FragmentModule;

import dagger.Component;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：FragmentComponent
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent
{
    AppCompatActivity getActivity();
}
