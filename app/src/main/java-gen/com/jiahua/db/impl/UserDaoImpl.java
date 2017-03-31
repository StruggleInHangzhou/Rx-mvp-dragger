package com.jiahua.db.impl;


import com.jiahua.db.entity.User;
import com.jiahua.db.generated.DaoSession;
import com.jiahua.db.generated.UserDao;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by jiahua on 17-2-24.
 * Description：
 */

public class UserDaoImpl
{
    private UserDao mDao;

    @Inject
    public UserDaoImpl(DaoSession session)
    {
        mDao = session.getUserDao();
    }

    public Observable<List<User>> loadAll_rx()
    {
        return mDao.rx().loadAll();
    }

    public void saveUserLists(final List<User> list)
    {
        if (list == null || list.isEmpty())
        {
            return;
        }
        mDao.getSession().runInTx(() ->
        {
            for (User user : list)
            {
                mDao.insertOrReplace(user);
            }
        });
    }

    public Observable<User> insertOrReplace(final User user)
    {
        return mDao.rx().insertOrReplace(user);
    }

    public Observable<List<User>> loadAll()
    {
        return mDao.rx().loadAll();
    }

}
