package com.jiahua.memory.rx_mvp_dragger.di.moudle;

import com.jiahua.db.THDevOpenHelper;
import com.jiahua.db.generated.DaoMaster;
import com.jiahua.db.generated.DaoSession;
import com.jiahua.memory.rx_mvp_dragger.App;
import com.jiahua.memory.rx_mvp_dragger.di.ContextLife;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：AppModule
 */
@Module
public class AppModule
{
    private final App application;

    public AppModule(App application)
    {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext()
    {
        return application;
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession()
    {
        return new DaoMaster(new THDevOpenHelper(application, "app_db", null).getWritableDatabase()).newSession();
    }

}