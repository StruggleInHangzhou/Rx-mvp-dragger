package com.jiahua.memory.ui.fragment.moudle;


import com.jiahua.db.entity.User;
import com.jiahua.memory.bean.query.UserQuery;
import com.jiahua.memory.net.ApiService;
import com.jiahua.memory.ui.fragment.contract.MissionContract;
import com.jiahua.memory.utils.ParamUtils;
import com.jiahua.network.ClientManager;
import com.jiahua.network.CommonResponse;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：xxx
 */
public class MissionMoudle implements MissionContract.IMoudle
{
    @Inject
    public MissionMoudle()
    {
    }

    @Override
    public Observable<CommonResponse<User>> login(UserQuery query)
    {
        return ClientManager.getClient().create(ApiService.class).login(query);
    }

    @Override
    public Observable<CommonResponse<String>> getVerificationCode(UserQuery query)
    {
        return ClientManager.getClient().create(ApiService.class).getVerificationCode(ParamUtils.createMapForObject(query));
    }

    @Override
    public Observable<CommonResponse<String>> captcha(String mobile)
    {
        return ClientManager.getClient().create(ApiService.class).captcha(mobile);
    }
}
