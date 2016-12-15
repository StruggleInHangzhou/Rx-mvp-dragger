package com.jiahua.memory.rx_mvp_dragger.core.mvp;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle.FragmentEvent;
import com.trello.rxlifecycle.FragmentLifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;

import rx.Observable;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：FragmentPresenter
 */
public class FragmentPresenter<V extends FragmentView> extends BasePresenter<V> implements FragmentLifecycleProvider
{
    @NonNull
    @Override
    public final Observable<FragmentEvent> lifecycle()
    {
        return getMvpView().lifecycle();
    }

    @NonNull
    @Override
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull FragmentEvent event)
    {
        return getMvpView().bindUntilEvent(event);
    }

    @NonNull
    @Override
    public final <T> LifecycleTransformer<T> bindToLifecycle()
    {
        return getMvpView().bindToLifecycle();
    }
}