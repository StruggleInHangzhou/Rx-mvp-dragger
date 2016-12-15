package com.jiahua.memory.rx_mvp_dragger.core.mvp;

import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.ActivityLifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：ActivityPresenter
 */
public class ActivityPresenter<V extends ActivityView> extends BasePresenter<V> implements ActivityLifecycleProvider
{

    @NonNull
    @Override
    public final Observable<ActivityEvent> lifecycle()
    {
        return getMvpView().lifecycle();
    }

    @NonNull
    @Override
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event)
    {
        return getMvpView().bindUntilEvent(event);
    }

    @NonNull
    @Override
    public final <T> LifecycleTransformer<T> bindToLifecycle()
    {
        return getMvpView().bindToLifecycle();
    }

    public <T> Observable.Transformer<T, T> callbackOnIOThread()
    {
        Logger.i("callbackOnIOThread");
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .filter(t -> isViewAttached())
                .compose(bindToLifecycle());
    }

    public <T> Observable.Transformer<T, T> verifyOnMainThread()
    {
        Logger.i("verifyOnMainThread");
        return tObservable -> tObservable.filter(t -> isViewAttached())
                .observeOn(AndroidSchedulers.mainThread());
    }
}