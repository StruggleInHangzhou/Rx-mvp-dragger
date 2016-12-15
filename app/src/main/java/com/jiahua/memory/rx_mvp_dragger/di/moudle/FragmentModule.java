package com.jiahua.memory.rx_mvp_dragger.di.moudle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.jiahua.memory.rx_mvp_dragger.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：FragmentModule
 */
@Module
public class FragmentModule
{
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public AppCompatActivity provideActivity() {
        return (AppCompatActivity) fragment.getActivity();
    }
}