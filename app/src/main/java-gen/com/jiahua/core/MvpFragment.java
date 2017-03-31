package com.jiahua.core;


import android.content.Context;
import android.os.Bundle;

import com.jiahua.core.mvp.MvpView;
import com.jiahua.core.mvp.Presenter;
import com.jiahua.di.component.DaggerFragmentComponent;
import com.jiahua.di.component.FragmentComponent;
import com.jiahua.di.moudle.FragmentModule;
import com.jiahua.memory.App;

import javax.inject.Inject;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：Mvp+dragger2
 */
public abstract class MvpFragment <T extends Presenter> extends IRxFragment implements MvpView
{
    protected Context mContext;
    @Inject
    protected T mPresenter;

    @Override
    public void onAttach(Context context)
    {
        mContext = context;
        super.onAttach(context);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initInject();
        mPresenter.attachView(this);
    }

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract void initInject();
}