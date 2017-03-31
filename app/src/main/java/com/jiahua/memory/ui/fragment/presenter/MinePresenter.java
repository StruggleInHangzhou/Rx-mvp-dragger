package com.jiahua.memory.ui.fragment.presenter;


import com.jiahua.core.mvp.FragmentPresenter;
import com.jiahua.memory.ui.fragment.contract.MineContract;
import com.jiahua.memory.ui.fragment.moudle.MineMoudle;

import javax.inject.Inject;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：xxx
 */
public class MinePresenter extends FragmentPresenter<MineContract.IView, MineMoudle> implements MineContract.IPresenter
{
    @Inject
    public MinePresenter()
    {
    }

    @Override
    public void getUserInfo()
    {

    }
}
