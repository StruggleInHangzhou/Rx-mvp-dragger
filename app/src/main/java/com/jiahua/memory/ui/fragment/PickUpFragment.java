package com.jiahua.memory.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiahua.core.BaseFragment;
import com.jiahua.memory.adapter.LoanAdapter;
import com.jiahua.memory.bean.LoanEntity;
import com.jiahua.memory.rx_mvp_dragger.R;
import com.jiahua.memory.rx_mvp_dragger.databinding.FragmentPickUpBinding;
import com.jiahua.memory.ui.fragment.contract.PickUpContract;
import com.jiahua.memory.ui.fragment.presenter.PickUpPresenter;

import java.util.List;

/**
 * Created by jhhuang on 2017/3/11
 * QQ:781913268
 * Description：接单
 */
public class PickUpFragment extends BaseFragment<PickUpPresenter> implements PickUpContract.IView
{
    private FragmentPickUpBinding mBinding;
    private LoanAdapter mLoanAdapter;
    private List<LoanEntity> mDatas;

    public static PickUpFragment create()
    {
        Bundle args = new Bundle();
        PickUpFragment fragment = new PickUpFragment();
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
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_pick_up, container, false);
        return mBinding.getRoot();
    }

    @Override
    protected void initViews(Bundle savedInstanceState)
    {
        super.initViews(savedInstanceState);
        setSwipeColor(mBinding.srlRoot);
        mBinding.title.title.setText(R.string.main_tab_3);
//        mBinding.srlRoot.setRefreshing(true);
    }

    @Override
    protected void initData()
    {
        super.initData();
//        mDatas = new ArrayList<>();
//        mLoanAdapter = new LoanAdapter(mContext, R.layout.item_loan, mDatas);
//        mBinding.rvContent.setLayoutManager(new LinearLayoutManager(mContext));
//        mBinding.rvContent.setAdapter(mLoanAdapter);

        mPresenter.loadData();
    }

    @Override
    protected void initEvent()
    {
        super.initEvent();
    }

    @Override
    public void notifyDataChange(List<LoanEntity> list)
    {
        mDatas.clear();
        mDatas.addAll(list);
        mLoanAdapter.notifyDataSetChanged();
    }
}
