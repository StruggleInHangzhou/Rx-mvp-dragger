package com.jiahua.memory.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiahua.core.BaseFragment;
import com.jiahua.memory.rx_mvp_dragger.R;
import com.jiahua.memory.rx_mvp_dragger.databinding.FragmentMineBinding;
import com.jiahua.memory.ui.fragment.contract.MineContract;
import com.jiahua.memory.ui.fragment.presenter.MinePresenter;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：我的
 */
public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.IView
{
    private FragmentMineBinding mBinding;

    public static MineFragment create()
    {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject()
    {
        getFragmentComponent().inject(this);
    }

    @Override
    protected View loadContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
        return mBinding.getRoot();
    }

    @Override
    protected void initViews(Bundle savedInstanceState)
    {
        super.initViews(savedInstanceState);
        mBinding.title.title.setText(R.string.main_tab_4);
    }

    @Override
    protected void initData()
    {
        super.initData();
        mPresenter.getUserInfo();
    }

    @Override
    protected void initEvent()
    {
        super.initEvent();
    }

}
