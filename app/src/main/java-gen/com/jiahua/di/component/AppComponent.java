package com.jiahua.di.component;


import com.jiahua.db.generated.DaoSession;
import com.jiahua.di.ContextLife;
import com.jiahua.di.moudle.AppModule;
import com.jiahua.memory.App;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jiahua on 17-2-22.
 * Description：
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent
{
    /**
     * @return 提供AppApplication
     */
    @ContextLife("Application")
    App getContext();

    DaoSession daoSessionHHelper();

}
