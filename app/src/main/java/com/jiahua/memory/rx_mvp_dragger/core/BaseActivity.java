package com.jiahua.memory.rx_mvp_dragger.core;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jiahua.memory.rx_mvp_dragger.core.mvp.ActivityPresenter;
import com.jiahua.memory.rx_mvp_dragger.core.mvp.ActivityView;
import com.jiahua.memory.rx_mvp_dragger.core.mvp.MvpActivity;
import com.jiahuaandroid.basetools.utils.ActivityCollector;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：BaseActivity+rx绑定生命周期
 */
public abstract class BaseActivity<T extends ActivityPresenter> extends MvpActivity<T> implements ActivityView
{
    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();
    protected AppCompatActivity mContext;
    protected Action1<Throwable> onError;
    protected Action0 onCompleted;

    @Override
    @CallSuper
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.i("onCreate");
        lifecycleSubject.onNext(ActivityEvent.CREATE);

        mContext = this;
        ActivityCollector.addActivity(this);
        onError = Throwable::printStackTrace;
        onCompleted = () -> Logger.e("onCompleted");

        setContentView(loadContentView());

        initViews(savedInstanceState);
        initData();
        initEvent();
    }

    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        Logger.i("onStart");
        lifecycleSubject.onNext(ActivityEvent.START);
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        Logger.i("onResume");
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    @CallSuper
    protected void onPause() {
        Logger.i("onPause");
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override
    @CallSuper
    protected void onStop() {
        Logger.i("onStop");
        lifecycleSubject.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override
    @CallSuper
    protected void onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY);

        Logger.i("onDestroy");
        ActivityCollector.removeActivity(this);
        super.onDestroy();
    }


    /**
     * 加载视图 setContentView()
     */
    protected abstract View loadContentView();

    /**
     * initialize the view in the layout
     *
     * @param savedInstanceState 状态信息
     */
    protected void initViews(Bundle savedInstanceState)
    {
        Logger.i("initViews");
    }

    /**
     * initialize the Activity data
     */
    protected void initData()
    {
        Logger.i("initData");
    }

    /**
     * initialize event
     */
    protected void initEvent()
    {
        Logger.i("initEvent");
    }

    @Override
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> lifecycle() {
        return lifecycleSubject.asObservable();
    }

    @Override
    @NonNull
    @CheckResult
    public final <R> LifecycleTransformer<R> bindUntilEvent(@NonNull ActivityEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <R> LifecycleTransformer<R> bindToLifecycle() {
        return RxLifecycle.bindActivity(lifecycleSubject);
    }

}