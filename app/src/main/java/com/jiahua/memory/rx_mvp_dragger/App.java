package com.jiahua.memory.rx_mvp_dragger;

import android.app.Application;

import com.jiahua.memory.rx_mvp_dragger.di.component.AppComponent;
import com.jiahua.memory.rx_mvp_dragger.di.component.DaggerAppComponent;
import com.jiahua.memory.rx_mvp_dragger.di.moudle.AppModule;
import com.jiahuaandroid.basetools.utils.CUtils;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions.RxPermissions;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：App
 */
public class App extends Application
{
    private static App instance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        //初始化日志
        Logger.init(getPackageName());
        //动态权限日志
        RxPermissions.getInstance(this).setLogging(BuildConfig.DEBUG);
        //工具加载
        CUtils.init(this);

    }

    public static AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }

}