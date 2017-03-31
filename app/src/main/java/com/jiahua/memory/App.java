package com.jiahua.memory;

import android.app.Application;

import com.jiahua.di.component.AppComponent;
import com.jiahua.di.component.DaggerAppComponent;
import com.jiahua.di.moudle.AppModule;
import com.jiahuaandroid.basetools.utils.CUtils;
import com.orhanobut.logger.Logger;

/**
 * Created by jiahua on 17-2-22.
 *  Description：
 */

public class App extends Application
{
    private static App instance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
//        CrashHandler.getInstance().init(instance);
        //初始化日志
        Logger.init(getPackageName());
        //工具加载
        CUtils.init(this);
    }

    public static AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }

    public static App getInstance()
    {
        return instance;
    }
}
