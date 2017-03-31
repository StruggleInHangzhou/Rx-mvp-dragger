package com.jiahua.memory.ui.fragment.contract;


import com.jiahua.core.mvp.FragmentView;
import com.jiahua.core.mvp.Moudle;
import com.jiahua.db.entity.User;
import com.jiahua.memory.bean.query.UserQuery;
import com.jiahua.network.CommonResponse;

import rx.Observable;

/**
 * Created by jhhuang on 2017/3/10
 * QQ:781913268
 * Description：xxx
 */
public interface MissionContract
{
    interface IMoudle extends Moudle
    {
        Observable<CommonResponse<User>> login(UserQuery query);

        Observable<CommonResponse<String>> getVerificationCode(UserQuery query);

        Observable<CommonResponse<String>> captcha(String mobile);
    }

    interface IView extends FragmentView
    {

    }

    interface IPresenter
    {
        void login();

        void getVerificationCode();

        void captcha(String mobile);

    }
}
