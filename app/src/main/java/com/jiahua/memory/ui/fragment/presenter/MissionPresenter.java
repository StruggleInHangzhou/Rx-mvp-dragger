package com.jiahua.memory.ui.fragment.presenter;


import com.jiahua.core.mvp.FragmentPresenter;
import com.jiahua.memory.ui.fragment.contract.MissionContract;
import com.jiahua.memory.ui.fragment.moudle.MissionMoudle;

import javax.inject.Inject;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：xxx
 */
public class MissionPresenter extends FragmentPresenter<MissionContract.IView,MissionMoudle> implements MissionContract.IPresenter
{
    @Inject
    public MissionPresenter()
    {
    }
}
