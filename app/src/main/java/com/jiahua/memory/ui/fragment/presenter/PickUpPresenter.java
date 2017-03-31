package com.jiahua.memory.ui.fragment.presenter;


import com.jiahua.core.mvp.FragmentPresenter;
import com.jiahua.memory.ui.fragment.contract.PickUpContract;
import com.jiahua.memory.ui.fragment.moudle.PickUpMoudle;

import javax.inject.Inject;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：xxx
 */
public class PickUpPresenter extends FragmentPresenter<PickUpContract.IView,PickUpMoudle> implements PickUpContract.IPresenter
{

    @Inject
    public PickUpPresenter()
    {
    }

    @Override
    public void loadData()
    {
    }


}
