package com.jiahua.memory.ui.activity.contract;


import com.jiahua.core.mvp.ActivityView;
import com.jiahua.core.mvp.Moudle;

/**
 * Created by jhhuang on 2016/12/13.
 * Description：
 */
public interface MainContract
{
    interface IMoudle extends Moudle
    {

    }

    interface IView extends ActivityView
    {
        void action2createLoanByInput();
    }

    interface IPresenter
    {

    }
}