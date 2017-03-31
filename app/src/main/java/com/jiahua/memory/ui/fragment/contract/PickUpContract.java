package com.jiahua.memory.ui.fragment.contract;


import com.jiahua.core.mvp.FragmentView;
import com.jiahua.core.mvp.Moudle;
import com.jiahua.memory.bean.LoanEntity;

import java.util.List;

/**
 * Created by jhhuang on 2017/3/10
 * QQ:781913268
 * Description：xxx
 */
public interface PickUpContract
{
    interface IMoudle extends Moudle
    {
    }

    interface IView extends FragmentView
    {
        void notifyDataChange(List<LoanEntity> list);
    }

    interface IPresenter
    {
        void loadData();
    }
}
