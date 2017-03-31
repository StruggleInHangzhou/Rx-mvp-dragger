package com.jiahua.core.mvp;

import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.android.ActivityEvent;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：ActivityView
 */
public interface ActivityView extends MvpView,LifecycleProvider<ActivityEvent>
{

}
