package com.jiahua.core;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiahua.core.mvp.FragmentPresenter;
import com.jiahua.core.mvp.FragmentView;

/**
 * Created by jhhuang on 2017/2/22.
 * QQ:781913268
 * Description：BaseFragment
 */
public abstract class BaseFragment<T extends FragmentPresenter> extends MvpFragment<T> implements FragmentView
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return loadContentView(inflater, container, savedInstanceState);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState)
    {
        super.onLazyInitView(savedInstanceState);
        initViews(savedInstanceState);
        initData();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        initEvent();
    }

    @Override
    public void hideLoading()
    {
        try
        {
            ((BaseActivity) mContext).hideLoading();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void showLoading()
    {
        try
        {
            ((BaseActivity) mContext).showLoading();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void showLoading(String msg)
    {
        try
        {
            ((BaseActivity) mContext).showLoading(msg);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void toast(String msg)
    {
        ((BaseActivity) mContext).toast(msg);
    }

    @Override
    public void toast(int resId)
    {
        ((BaseActivity) mContext).toast(resId);
    }

    /**
     * 加载视图
     */
    protected abstract View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * initialize the view in the layout
     *
     * @param savedInstanceState
     */
    protected void initViews(Bundle savedInstanceState)
    {

    }

    /**
     * initialize the Activity data
     */
    protected void initData()
    {

    }

    /**
     * initialize event
     */
    protected void initEvent()
    {

    }

    /**
     * 更新颜色
     * @param swipe 布局
     */
    public void setSwipeColor(SwipeRefreshLayout swipe)
    {
        swipe.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
    }
}