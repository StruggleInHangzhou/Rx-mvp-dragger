package com.jiahua.db.impl;

import com.jiahua.db.bean.User;
import com.jiahua.db.generated.DaoSession;
import com.jiahua.db.generated.UserDao;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by jhhuang on 2016/12/14.
 * QQ:781913268
 * Description：UserDaoImpl
 */
public class UserDaoImpl
{
    private UserDao mDao;

    @Inject
    public UserDaoImpl(DaoSession session)
    {
        mDao = session.getUserDao();
    }


    public void saveUserLists(final List<User> list)
    {
        if (list == null || list.isEmpty())
        {
            return;
        }
        mDao.getSession().runInTx(() -> {
            for (User user : list)
            {
                mDao.insertOrReplace(user);
            }
        });
    }

    public Observable<List<User>> loadAll_rx()
    {
        return mDao.rx().loadAll();
    }
}