package com.jiahua.memory.ui.fragment.presenter;


import com.jiahua.core.mvp.FragmentPresenter;
import com.jiahua.db.entity.User;
import com.jiahua.memory.bean.dto.UserDTO;
import com.jiahua.memory.bean.query.UserQuery;
import com.jiahua.memory.ui.fragment.contract.MissionContract;
import com.jiahua.memory.ui.fragment.moudle.MissionMoudle;
import com.jiahua.network.CommonResponse;

import javax.inject.Inject;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：xxx
 */
public class MissionPresenter extends FragmentPresenter<MissionContract.IView, MissionMoudle> implements MissionContract.IPresenter
{
    private UserQuery query;

    @Inject
    public MissionPresenter()
    {
        query = new UserQuery();
    }

    @Override
    public void login()
    {
        mMoudle.login(query)
                .compose(callbackOnIOThread())
                .map(CommonResponse::getData)
                .compose(verifyOnMainThread())
                .subscribe(new NetSubseriber<User>()
                {
                    @Override
                    public void onNext(User user)
                    {

                    }
                });
    }

    @Override
    public void getVerificationCode()
    {
        mMoudle.getVerificationCode(query)
                .compose(callbackOnIOThread())
                .map(CommonResponse::getData)
                .compose(verifyOnMainThread())
                .subscribe(new NetSubseriber<UserDTO>()
                {
                    @Override
                    public void onNext(UserDTO dto)
                    {

                    }
                });
    }

    @Override
    public void captcha(String mobile)
    {
        mMoudle.captcha(mobile)
                .compose(callbackOnIOThread())
                .map(CommonResponse::getData)
                .compose(verifyOnMainThread())
                .subscribe(new NetSubseriber<String>()
                {
                    @Override
                    public void onNext(String s)
                    {

                    }
                });
    }
}
