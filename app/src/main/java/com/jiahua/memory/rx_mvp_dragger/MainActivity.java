package com.jiahua.memory.rx_mvp_dragger;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.jakewharton.rxbinding.view.RxView;
import com.jiahua.db.bean.User;
import com.jiahua.memory.rx_mvp_dragger.adapter.UserAdapter;
import com.jiahua.memory.rx_mvp_dragger.core.BaseActivity;
import com.jiahua.memory.rx_mvp_dragger.databinding.ActivityMainBinding;
import com.jiahua.memory.rx_mvp_dragger.other.Config;
import com.jiahua.memory.rx_mvp_dragger.ui.activity.presenter.MainPresenter;
import com.jiahua.memory.rx_mvp_dragger.ui.contract.MainContract;
import com.jiahuaandroid.basetools.adapter.recyclerview.MultiItemTypeAdapter;
import com.jiahuaandroid.basetools.utils.CUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IView
{
    private ActivityMainBinding mBinding;
    private UserAdapter mUserAdapter;
    private List<User> mUserList;

    @Override
    protected void initInject()
    {
        getActivityComponent().inject(this);
    }

    @Override
    protected View loadContentView()
    {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.activity_main, null, false);
        return mBinding.getRoot();
    }

    @Override
    protected void initViews(Bundle savedInstanceState)
    {
        super.initViews(savedInstanceState);
    }

    @Override
    protected void initData()
    {
        super.initData();
        mUserList = new ArrayList<>();
        mUserAdapter = new UserAdapter(mContext, R.layout.item_user, mUserList);
        mBinding.rvUser.setLayoutManager(new LinearLayoutManager(mContext));
        mBinding.rvUser.setAdapter(mUserAdapter);
    }

    @Override
    protected void initEvent()
    {
        super.initEvent();

        RxView.clicks(mBinding.btnLoad)
                .compose(bindToLifecycle())
                .throttleFirst(Config.TIME_THROTTLE, TimeUnit.MILLISECONDS)
                .subscribe(aVoid -> mPresenter.getData());

        RxView.clicks(mBinding.btnSave)
                .compose(bindToLifecycle())
                .throttleFirst(Config.TIME_THROTTLE, TimeUnit.MILLISECONDS)
                .subscribe(aVoid -> mPresenter.saveUserList(new ArrayList<>()));

        mUserAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position)
            {
                CUtils.showMsg(mUserList.get(position).getName());
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position)
            {
                return false;
            }
        });
    }

    @Override
    public void notifyAdater(List<User> list)
    {
        mUserList.addAll(list);
        mUserAdapter.notifyDataSetChanged();
    }
}
