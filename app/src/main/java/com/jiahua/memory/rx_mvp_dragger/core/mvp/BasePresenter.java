package com.jiahua.memory.rx_mvp_dragger.core.mvp;

import com.orhanobut.logger.Logger;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import rx.functions.Action1;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：BasePresenter
 */
public class BasePresenter<V extends MvpView> implements Presenter<V>
{
    private Reference<V> mMvpView;
    protected Action1<Throwable> onError;

    public BasePresenter()
    {
        onError = Throwable::printStackTrace;
    }

    @Override
    public void attachView(V mvpView)
    {
        this.mMvpView = new WeakReference<>(mvpView);
        Logger.i("");
    }

    @Override
    public void detachView()
    {
        if (this.mMvpView != null)
        {
            this.mMvpView.clear();
            this.mMvpView = null;
        }
    }

    /**
     * @return 是否已经关联
     */
    public boolean isViewAttached()
    {
        return mMvpView != null && mMvpView.get() != null;
    }

    /**
     * @return 获取接口
     */
    public V getMvpView()
    {
        return mMvpView.get();
    }

    /**
     * 检查是否关联并抛出自定义异常
     */
    public void checkViewAttached()
    {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }


    private static class MvpViewNotAttachedException extends RuntimeException
    {
        MvpViewNotAttachedException()
        {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
