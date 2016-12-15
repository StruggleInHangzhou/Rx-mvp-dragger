package com.jiahua.memory.rx_mvp_dragger.core.mvp;

import android.os.Bundle;

import com.jiahua.memory.rx_mvp_dragger.App;
import com.jiahua.memory.rx_mvp_dragger.di.component.ActivityComponent;
import com.jiahua.memory.rx_mvp_dragger.di.component.DaggerActivityComponent;
import com.jiahua.memory.rx_mvp_dragger.di.moudle.ActivityModule;

import javax.inject.Inject;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：Mvp + dragger2
 */
public abstract class MvpActivity<T extends Presenter> extends SupportActivity implements MvpView
{
    @Inject
    protected T mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initInject();
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