package com.jiahua.core;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.jiahua.memory.rx_mvp_dragger.BuildConfig;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/**
 * Created by jhhuang on 2017/2/22.
 * QQ:781913268
 * Description：IRxActivity
 */
public class IRxActivity extends EmptyActivity implements LifecycleProvider<ActivityEvent>
{
    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();

    protected Action1<Throwable> onError;
    protected Action0 onCompleted;
    protected RxPermissions mRxPermissions;

    @Override
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> lifecycle() {
        return lifecycleSubject.asObservable();
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycleAndroid.bindActivity(lifecycleSubject);
    }

    @Override
    @CallSuper
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onError = Throwable::printStackTrace;
        onCompleted = () -> Logger.i(this.getClass().getName()+"onCompleted");
        mRxPermissions =new RxPermissions(this);
        mRxPermissions.setLogging(BuildConfig.DEBUG);
        Logger.i(getClass().getName()+":onCreate");
        lifecycleSubject.onNext(ActivityEvent.CREATE);
    }

    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        Logger.i(getClass().getName()+":onStart");
        lifecycleSubject.onNext(ActivityEvent.START);
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        Logger.i(getClass().getName()+":onResume");
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    @CallSuper
    protected void onPause() {
        Logger.i(getClass().getName()+":onPause");
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override
    @CallSuper
    protected void onStop() {
        Logger.i(getClass().getName()+":onStop");
        lifecycleSubject.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override
    @CallSuper
    protected void onDestroy() {
        Logger.i(getClass().getName()+":onDestroy");
        lifecycleSubject.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }
}