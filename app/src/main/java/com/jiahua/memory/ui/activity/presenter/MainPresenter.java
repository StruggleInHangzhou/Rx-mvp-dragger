package com.jiahua.memory.ui.activity.presenter;


import com.jiahua.core.mvp.ActivityPresenter;
import com.jiahua.memory.ui.activity.contract.MainContract;
import com.jiahua.memory.ui.activity.moudle.MainMoudle;

import javax.inject.Inject;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：MainPresenter
 */
public class MainPresenter extends ActivityPresenter<MainContract.IView,MainMoudle> implements MainContract.IPresenter
{

    @Inject
    public MainPresenter()
    {
    }

}