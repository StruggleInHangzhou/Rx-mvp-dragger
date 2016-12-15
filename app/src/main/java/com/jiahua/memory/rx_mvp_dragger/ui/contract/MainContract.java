package com.jiahua.memory.rx_mvp_dragger.ui.contract;

import com.jiahua.db.bean.User;
import com.jiahua.memory.rx_mvp_dragger.core.mvp.ActivityView;

import java.util.List;

import rx.Observable;

/**
 * Created by jhhuang on 2016/12/13.
 * QQ:781913268
 * Description：MainContract MVP模式中的协议类
 */
public class MainContract
{
    public interface IMoudle
    {
        void saveUserList(List<User> list);

        Observable<List<User>> loadAll_rx();
    }

    public interface IView extends ActivityView
    {
        void notifyAdater(List<User> list);
    }

    public interface IPresenter
    {
        void getData();

        void saveUserList(List<User> list);
    }
}