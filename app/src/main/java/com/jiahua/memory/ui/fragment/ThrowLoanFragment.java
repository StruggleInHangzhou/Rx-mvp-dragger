package com.jiahua.memory.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiahua.core.BaseFragment;
import com.jiahua.memory.rx_mvp_dragger.R;
import com.jiahua.memory.rx_mvp_dragger.databinding.FragmentThrowLoanBinding;
import com.jiahua.memory.ui.fragment.contract.ThrowLoanContract;
import com.jiahua.memory.ui.fragment.presenter.ThrowLoanPresenter;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：甩单
 */
public class ThrowLoanFragment extends BaseFragment<ThrowLoanPresenter> implements ThrowLoanContract.IView
{
    private FragmentThrowLoanBinding mBinding;

    public static ThrowLoanFragment create()
    {
        Bundle args = new Bundle();
        ThrowLoanFragment fragment = new ThrowLoanFragment();
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
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_throw_loan, container, false);
        return mBinding.getRoot();
    }

    @Override
    protected void initViews(Bundle savedInstanceState)
    {
        super.initViews(savedInstanceState);
        mBinding.title.title.setText(R.string.main_tab_2);
    }

    @Override
    protected void initData()
    {
        super.initData();
    }

    @Override
    protected void initEvent()
    {
        super.initEvent();
    }
}
