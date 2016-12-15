package com.jiahua.memory.rx_mvp_dragger.di.component;

import com.jiahua.db.generated.DaoSession;
import com.jiahua.memory.rx_mvp_dragger.App;
import com.jiahua.memory.rx_mvp_dragger.di.ContextLife;
import com.jiahua.memory.rx_mvp_dragger.di.moudle.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：AppComponent
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
