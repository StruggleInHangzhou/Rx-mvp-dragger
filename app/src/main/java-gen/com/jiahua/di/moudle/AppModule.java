package com.jiahua.di.moudle;


import com.jiahua.db.THDevOpenHelper;
import com.jiahua.db.generated.DaoMaster;
import com.jiahua.db.generated.DaoSession;
import com.jiahua.di.ContextLife;
import com.jiahua.memory.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jiahua on 17-2-22.
 * Description：
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
