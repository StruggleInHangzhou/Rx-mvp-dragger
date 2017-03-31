package com.jiahua.di.component;


import android.support.v7.app.AppCompatActivity;

import com.jiahua.di.FragmentScope;
import com.jiahua.di.moudle.FragmentModule;
import com.jiahua.memory.ui.fragment.MineFragment;
import com.jiahua.memory.ui.fragment.MissionFragment;
import com.jiahua.memory.ui.fragment.PickUpFragment;
import com.jiahua.memory.ui.fragment.ThrowLoanFragment;

import dagger.Component;

/**
 * Created by jiahua on 17-2-22.
 * Description：
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent
{
    AppCompatActivity getActivity();

    void inject(MineFragment fragment);

    void inject(PickUpFragment fragment);

    void inject(ThrowLoanFragment fragment);

    void inject(MissionFragment fragment);

}

