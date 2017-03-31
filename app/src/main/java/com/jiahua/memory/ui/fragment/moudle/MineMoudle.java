package com.jiahua.memory.ui.fragment.moudle;


import com.jiahua.db.entity.User;
import com.jiahua.db.impl.UserDaoImpl;
import com.jiahua.memory.ui.fragment.contract.MineContract;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：xxx
 */
public class MineMoudle implements MineContract.IMoudle
{
    @Inject
    protected UserDaoImpl mDao;

    @Inject
    public MineMoudle()
    {
    }

    @Override
    public Observable<List<User>> loadAll()
    {
        return mDao.loadAll();
    }
}
