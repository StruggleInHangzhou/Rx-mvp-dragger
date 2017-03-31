package com.jiahua.memory.net;


import com.jiahua.db.entity.User;
import com.jiahua.memory.bean.query.UserQuery;
import com.jiahua.network.CommonResponse;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by jiahua on 17-2-24.
 * Description：
 */

public interface ApiService
{
    @POST("auth/app/login")
    Observable<CommonResponse<User>> login(@Body UserQuery query);

    @FormUrlEncoded
    @POST("user/getVerificationCode.do")
    Observable<CommonResponse<String>> getVerificationCode(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("auth/resetPwd/captcha")
    Observable<CommonResponse<String>> captcha(@Field("mobile") String mobile);

}