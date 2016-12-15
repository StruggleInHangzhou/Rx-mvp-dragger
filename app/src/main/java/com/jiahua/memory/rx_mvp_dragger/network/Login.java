package com.jiahua.memory.rx_mvp_dragger.network;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by jhhuang on 2016/12/1.
 * QQ:781913268
 * Description：Login
 */

public interface Login
{
    @FormUrlEncoded
    @POST("auth/app_login")
    Observable<String> login(@FieldMap Map<String, String> params);
}
