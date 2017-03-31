package com.jiahua.core.mvp;

import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.android.FragmentEvent;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：FragmentView
 */
public interface FragmentView extends MvpView,LifecycleProvider<FragmentEvent>
{

}
