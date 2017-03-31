package com.jiahua.memory.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiahua.core.BaseFragment;
import com.jiahua.memory.rx_mvp_dragger.R;
import com.jiahua.memory.rx_mvp_dragger.databinding.FragmentMissionBinding;
import com.jiahua.memory.ui.fragment.contract.MissionContract;
import com.jiahua.memory.ui.fragment.presenter.MissionPresenter;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：消息
 */
public class MissionFragment extends BaseFragment<MissionPresenter> implements MissionContract.IView
{
    private FragmentMissionBinding mBinding;
    public static MissionFragment create() {
        Bundle args = new Bundle();
        MissionFragment fragment = new MissionFragment();
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
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mission, container, false);
        return mBinding.getRoot();
    }

    @Override
    protected void initViews(Bundle savedInstanceState)
    {
        super.initViews(savedInstanceState);
        mBinding.title.title.setText(R.string.main_tab_1);
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
