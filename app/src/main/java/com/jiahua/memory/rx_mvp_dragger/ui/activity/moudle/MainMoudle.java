package com.jiahua.memory.rx_mvp_dragger.ui.activity.moudle;

import com.jiahua.db.bean.User;
import com.jiahua.db.impl.UserDaoImpl;
import com.jiahua.memory.rx_mvp_dragger.ui.contract.MainContract;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：MainMoudle
 */
public class MainMoudle implements MainContract.IMoudle
{
    private UserDaoImpl mUserDao;

    @Inject
    public MainMoudle(UserDaoImpl userDao)
    {
        this.mUserDao = userDao;
    }

    @Override
    public void saveUserList(List<User> list)
    {
        mUserDao.saveUserLists(list);
    }

    @Override
    public Observable<List<User>> loadAll_rx()
    {
        return mUserDao.loadAll_rx();
    }
}