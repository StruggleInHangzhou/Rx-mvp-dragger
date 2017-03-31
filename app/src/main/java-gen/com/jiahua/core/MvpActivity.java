package com.jiahua.core;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jiahua.core.mvp.MvpView;
import com.jiahua.core.mvp.Presenter;
import com.jiahua.di.component.ActivityComponent;
import com.jiahua.di.component.DaggerActivityComponent;
import com.jiahua.di.moudle.ActivityModule;
import com.jiahua.memory.App;

import javax.inject.Inject;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：Mvp + dragger2
 */
public abstract class MvpActivity<T extends Presenter> extends IRxActivity implements MvpView
{
    @Inject
    protected T mPresenter;
    protected AppCompatActivity mContext;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initInject();
        mContext = this;
        if (mPresenter != null)
        {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
     * dragger2注册
     */
    protected abstract void initInject();

    protected ActivityComponent getActivityComponent()
    {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule()
    {
        return new ActivityModule(this);
    }
}