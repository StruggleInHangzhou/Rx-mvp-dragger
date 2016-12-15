package com.jiahua.memory.rx_mvp_dragger.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by jhhuang on 16/8/7.
 * QQ:781913268
 * Description：xxx
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ContextLife
{
    String value() default "Application";
}
