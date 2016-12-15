package com.jiahua.memory.rx_mvp_dragger.core;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiahua.memory.rx_mvp_dragger.core.mvp.FragmentPresenter;
import com.jiahua.memory.rx_mvp_dragger.core.mvp.FragmentView;
import com.jiahua.memory.rx_mvp_dragger.core.mvp.MvpFragment;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.FragmentEvent;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;

import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：BaseFragment lazyload rx生命周期管理
 */
public abstract class BaseFragment<T extends FragmentPresenter> extends MvpFragment<T> implements FragmentView
{
    private final BehaviorSubject<FragmentEvent> lifecycleSubject = BehaviorSubject.create();
    protected Action1<Throwable> onError;

    @Override
    @CallSuper
    public void onAttach(Context context)
    {
        super.onAttach(context);
        Logger.i("onAttach");
        lifecycleSubject.onNext(FragmentEvent.ATTACH);
    }

    @Override
    @CallSuper
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Logger.i("onCreate");
        lifecycleSubject.onNext(FragmentEvent.CREATE);

        onError = Throwable::printStackTrace;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        Logger.i("onCreateView");
        return loadContentView(inflater, container, savedInstanceState);
    }

    @Override
    @CallSuper
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Logger.i("onViewCreated");
        lifecycleSubject.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState)
    {
        super.onLazyInitView(savedInstanceState);
        Logger.i("onLazyInitView");
        initFragment(savedInstanceState);
    }

    @Override
    @CallSuper
    public void onStart()
    {
        super.onStart();
        Logger.i("onStart");
        lifecycleSubject.onNext(FragmentEvent.START);
    }

    @Override
    @CallSuper
    public void onResume()
    {
        super.onResume();
        Logger.i("onResume");
        lifecycleSubject.onNext(FragmentEvent.RESUME);
    }

    @Override
    @CallSuper
    public void onPause()
    {
        Logger.i("onPause");
        lifecycleSubject.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override
    @CallSuper
    public void onStop()
    {
        Logger.i("onStop");
        lifecycleSubject.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override
    @CallSuper
    public void onDestroyView()
    {
        Logger.i("onDestroyView");
        lifecycleSubject.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override
    @CallSuper
    public void onDestroy()
    {
        Logger.i("onDestroy");
        lifecycleSubject.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override
    @CallSuper
    public void onDetach()
    {
        Logger.i("onDetach");
        lifecycleSubject.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    private void initFragment(Bundle savedInstanceState)
    {
        initViews(savedInstanceState);
        initData();
        initEvent();
    }


    /**
     * initialize the view in the layout
     *
     * @param savedInstanceState
     */
    protected void initViews(Bundle savedInstanceState)
    {

    }

    /**
     * initialize the Activity data
     */
    protected void initData()
    {

    }

    /**
     * initialize event
     */
    protected void initEvent()
    {

    }


    @Override
    @NonNull
    @CheckResult
    public final Observable<FragmentEvent> lifecycle()
    {
        return lifecycleSubject.asObservable();
    }

    @Override
    @NonNull
    @CheckResult
    public final <R> LifecycleTransformer<R> bindUntilEvent(@NonNull FragmentEvent event)
    {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <R> LifecycleTransformer<R> bindToLifecycle()
    {
        return RxLifecycle.bindFragment(lifecycleSubject);
    }

    /**
     * 加载视图 setContentView()
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     */
    protected abstract View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

}