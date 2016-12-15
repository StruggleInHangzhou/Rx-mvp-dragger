package com.jiahua.memory.rx_mvp_dragger.ui.activity.presenter;

import com.jiahua.db.bean.User;
import com.jiahua.memory.rx_mvp_dragger.core.mvp.ActivityPresenter;
import com.jiahua.memory.rx_mvp_dragger.ui.activity.moudle.MainMoudle;
import com.jiahua.memory.rx_mvp_dragger.ui.contract.MainContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：MainPresenter
 */
public class MainPresenter extends ActivityPresenter<MainContract.IView> implements MainContract.IPresenter
{
    @Inject
    protected MainMoudle mMoudle;
    /**
     * 用户id  放入数据库惟一标识
     */
    private int id;

    @Inject
    public MainPresenter()
    {
    }

    @Override
    public void getData()
    {
        mMoudle.loadAll_rx()
                .compose(callbackOnIOThread())
                .compose(verifyOnMainThread())
                .subscribe(list -> getMvpView().notifyAdater(list), onError);
    }

    @Override
    public void saveUserList(List<User> list)
    {
        list.add(new User(String.valueOf(id), id * 2, "张三" + String.valueOf(id)));
        id++;
        mMoudle.saveUserList(list);
    }
}