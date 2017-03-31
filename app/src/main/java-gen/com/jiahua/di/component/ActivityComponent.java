package com.jiahua.di.component;


import android.support.v7.app.AppCompatActivity;

import com.jiahua.di.ActivityScope;
import com.jiahua.di.moudle.ActivityModule;
import com.jiahua.memory.MainActivity;

import dagger.Component;

/**
 * Created by jiahua on 17-2-22.
 * Description：
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent
{
    AppCompatActivity getActivity();

    void inject(MainActivity activity);

}