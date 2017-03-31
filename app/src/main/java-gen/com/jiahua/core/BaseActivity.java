package com.jiahua.core;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import com.jiahua.core.mvp.ActivityPresenter;
import com.jiahua.core.mvp.ActivityView;
import com.jiahua.memory.rx_mvp_dragger.R;
import com.jiahuaandroid.basetools.utils.ActivityCollector;
import com.jiahuaandroid.basetools.utils.CUtils;
import com.jiahuaandroid.basetools.utils.StatusBarUtils;
import com.orhanobut.logger.Logger;

/**
 * Created by jhhuang on 2017/2/22.
 * QQ:781913268
 * Description：BaseActivity
 */
public abstract class BaseActivity<T extends ActivityPresenter> extends MvpActivity<T> implements ActivityView
{
    private FrameLayout rootView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_base);
        fbi();
        rootView.addView(loadContentView(), 0);
        initViews(savedInstanceState);
        initData();
        initEvents();
    }

    private void fbi()
    {
        rootView = (FrameLayout) findViewById(R.id.fl_root);
    }

    protected void parseIntent(Intent intent)
    {
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    public void setContentView(int layoutResID)
    {
        super.setContentView(layoutResID);
        this.setStatusBar();
    }

    @Override
    protected void onDestroy()
    {
        ActivityCollector.removeActivity(this);
        super.onDestroy();
    }

    /**
     * 加载视图 setContentView()
     */
    protected abstract View loadContentView();

    /**
     * initialize the view in the layout
     *
     * @param savedInstanceState 状态信息
     */
    protected void initViews(Bundle savedInstanceState)
    {
        Logger.i(getClass().getName() + ":initViews");
    }

    /**
     * initialize the Activity data
     */
    protected void initData()
    {
        Logger.i(getClass().getName() + ":initData");
    }

    /**
     * initialize event
     */
    protected void initEvents()
    {
        Logger.i(getClass().getName() + ":initEvents");
    }

    protected void setStatusBar()
    {
        if (!ifFullScreen())
        {
            StatusBarUtils.setColor(this, Color.parseColor("#47B3FE"));
        }
    }

    /**
     * 判断当前activity是否为全屏
     *
     * @return true？全屏：不是全屏
     */
    protected boolean ifFullScreen()
    {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        return ((attrs.flags & WindowManager.LayoutParams.FLAG_FULLSCREEN) == WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * @param to 窗口透明度 1f表示正常。0表示全黑
     */
    protected void backgroundAlpha(float to)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = to;
        getWindow().setAttributes(lp);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    /**
     * @param v 隐藏输入法
     */
    protected void hideKeyboard(View v)
    {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive())
        {
            imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
        }
    }

    /**
     * 更新颜色
     * @param swipe 布局
     */
    public void setSwipeColor(SwipeRefreshLayout swipe)
    {
        swipe.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
    }

    /**
     * 判断输入法是否显示
     *
     * @param rootView
     * @return
     */
    public boolean isKeyboardShown(View rootView)
    {
        final int softKeyboardHeight = 100;
        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
        int heightDiff = rootView.getBottom() - r.bottom;
        return heightDiff > softKeyboardHeight * dm.density;
    }

    @Override
    public void showLoading()
    {
    }

    @Override
    public void showLoading(String msg)
    {
    }

    @Override
    public void hideLoading()
    {
    }

    @Override
    public void toast(String msg)
    {
        mContext.runOnUiThread(() -> CUtils.showMsg(msg));
    }

    @Override
    public void toast(int resId)
    {
        mContext.runOnUiThread(() -> CUtils.showMsg(resId));
    }
}