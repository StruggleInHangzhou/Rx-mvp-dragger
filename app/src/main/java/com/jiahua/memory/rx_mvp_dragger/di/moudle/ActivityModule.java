package com.jiahua.memory.rx_mvp_dragger.di.moudle;

import android.support.v7.app.AppCompatActivity;

import com.jiahua.memory.rx_mvp_dragger.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：ActivityModule
 */
@Module
public class ActivityModule
{
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity)
    {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public AppCompatActivity provideActivity()
    {
        return mActivity;
    }
}