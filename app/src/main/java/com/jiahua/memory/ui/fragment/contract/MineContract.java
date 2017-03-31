package com.jiahua.memory.ui.fragment.contract;


import com.jiahua.core.mvp.FragmentView;
import com.jiahua.core.mvp.Moudle;
import com.jiahua.db.entity.User;

import java.util.List;

import rx.Observable;

/**
 * Created by jhhuang on 2017/3/10
 * QQ:781913268
 * Description：xxx
 */
public interface MineContract
{
    interface IMoudle extends Moudle
    {
        Observable<List<User>> loadAll();
    }

    interface IView extends FragmentView
    {
    }

    interface IPresenter
    {
        void getUserInfo();
    }
}
