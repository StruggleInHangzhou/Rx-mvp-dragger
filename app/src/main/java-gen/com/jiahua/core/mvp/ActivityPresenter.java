package com.jiahua.core.mvp;


import android.support.annotation.NonNull;

import com.jiahua.memory.rx_mvp_dragger.R;
import com.jiahua.network.ex.ApiException;
import com.jiahua.network.ex.ResultException;
import com.jiahua.network.ex.ToastException;
import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：ActivityPresenter
 */
public class ActivityPresenter<V extends ActivityView, M extends Moudle> extends BasePresenter<V, M> implements LifecycleProvider<ActivityEvent>
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
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .filter(t -> isViewAttached())
                .compose(bindToLifecycle());
    }

    public <T> Observable.Transformer<T, T> verifyOnMainThread()
    {
        return tObservable -> tObservable.filter(t -> isViewAttached())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public abstract class NetSubseriber<T> extends Subscriber<T>
    {

        @Override
        public void onStart()
        {
            super.onStart();
            if (isViewAttached())
            {
                getMvpView().showLoading();
            }
        }

        @Override
        public void onCompleted()
        {
            if (isViewAttached())
            {
                getMvpView().hideLoading();
            }
        }

        @Override
        public void onError(Throwable e)
        {
            e.printStackTrace();
            if (!isViewAttached())
            {
                return;
            }
            getMvpView().hideLoading();
            if (e instanceof ToastException)
            {
                getMvpView().toast(e.getMessage());
            } else if (e instanceof ResultException)
            {
                onResultError(((ResultException) e));
            } else if (e instanceof HttpException)
            {
                onHttpError(((HttpException) e));
            } else if (e instanceof SocketTimeoutException)
            {
                onSocketTimeoutException(((SocketTimeoutException) e));
            } else if (e instanceof ApiException)
            {
                onApiException(((ApiException) e));
            } else if (e instanceof ConnectException)
            {
                onConnectException(((ConnectException) e));
            } else
            {
                onOtherError(e);
            }
        }

        public void onApiException(ApiException e)
        {

        }

        public void onOtherError(Throwable e)
        {
            getMvpView().toast(R.string.error_not_know);
        }

        public void onResultError(ResultException e)
        {
            getMvpView().toast(e.getMessage());
        }

        public void onHttpError(HttpException e)
        {
            getMvpView().toast(R.string.error_http);
        }

        public void onSocketTimeoutException(SocketTimeoutException e)
        {
            getMvpView().toast(R.string.error_socket_time_out);
        }

        public void onConnectException(ConnectException e)
        {
            getMvpView().toast(R.string.error_not_connect);
        }
    }

}