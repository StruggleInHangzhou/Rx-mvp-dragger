package com.jiahua.network;

import android.text.TextUtils;
import android.util.Log;

import com.jiahua.memory.App;
import com.jiahua.memory.other.Config;
import com.jiahua.memory.rx_mvp_dragger.BuildConfig;
import com.jiahua.network.modify.GsonConverterFactory;
import com.jiahuaandroid.basetools.utils.ACache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by jhhuang on 2016/5/19.
 * QQ:781913268
 * Description：AppClient
 */
public class AppClient
{
    private static Converter.Factory scalarsconverterfactory = ScalarsConverterFactory.create();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    public static String baseUrl = "http://192.168.0.105:9080/";
//    public static String baseUrl = "http://192.168.2.236:8099/";
    private Retrofit retrofit;

    public AppClient()
    {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS);

        if (BuildConfig.DEBUG)
        {
            builder.addInterceptor(new LoggerInterceptor("http", true));
        }

        OkHttpClient okHttpClient = builder.build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(scalarsconverterfactory)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .baseUrl(baseUrl)
                .build();

    }

    public AppClient(String url)
    {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS);

        if (BuildConfig.DEBUG)
        {
            builder.addInterceptor(new LoggerInterceptor("http", true));
        }

        OkHttpClient okHttpClient = builder.build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(scalarsconverterfactory)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .baseUrl(url)
                .build();

    }


    public <T> T create(Class<T> clazz)
    {
        return retrofit.create(clazz);
    }

    /**
     * 全局头信息
     */
    class HeaderInterceptor implements Interceptor
    {

        @Override
        public Response intercept(Chain chain) throws IOException
        {
            Request request = chain.request();
            String path = request.url().encodedPath();
            Log.d("AppClient", path + ">>>query");
            //这里设置成你的全局header
            Headers headers = request.headers();
            Request.Builder builder = chain.request().newBuilder()
                    .headers(headers);

            String deviceId = ACache.get(App.getInstance()).getAsString(Config.DEVICE_ID);
            if (!TextUtils.isEmpty(deviceId))
            {
                builder.addHeader("deviceId", deviceId);
            }
            String token = ACache.get(App.getInstance()).getAsString(Config.TOKEN);
            if (!TextUtils.isEmpty(token))
            {
                builder.addHeader("token", token);
            }
            String deviceKey = ACache.get(App.getInstance()).getAsString(Config.KEY_DEVICE);
            if (!TextUtils.isEmpty(deviceKey))
            {
                builder.addHeader("deviceKey", deviceKey);
            }
            builder.addHeader("appName", "csgx");
            Request interRequest = builder.build();
            return chain.proceed(interRequest);
        }
    }
}


