package com.jiahua.memory;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.jiahua.core.BaseActivity;
import com.jiahua.memory.rx_mvp_dragger.R;
import com.jiahua.memory.rx_mvp_dragger.databinding.ActivityMainBinding;
import com.jiahua.memory.ui.activity.contract.MainContract;
import com.jiahua.memory.ui.activity.presenter.MainPresenter;
import com.jiahua.memory.ui.fragment.MineFragment;
import com.jiahua.memory.ui.fragment.MissionFragment;
import com.jiahua.memory.ui.fragment.PickUpFragment;
import com.jiahua.memory.ui.fragment.ThrowLoanFragment;
import com.jiahua.memory.view.BottomBar;
import com.jiahua.memory.view.BottomBarTab;
import com.jiahuaandroid.basetools.utils.ActivityCollector;

import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IView
{
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOUR = 3;

    private ActivityMainBinding mBinding;

    private SupportFragment[] mFragments = new SupportFragment[4];


    @Override
    protected View loadContentView()
    {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.activity_main, null, false);
        return mBinding.getRoot();
    }

    @Override
    protected void initInject()
    {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState)
    {
        super.initViews(savedInstanceState);
        initFragment(savedInstanceState);
        mBinding.bottomBar.addItem(new BottomBarTab(mContext, R.mipmap.ic_perm_identity_grey_400_18dp, getString(R.string.main_tab_1)))
                .addItem(new BottomBarTab(mContext, R.mipmap.ic_perm_identity_grey_400_18dp, getString(R.string.main_tab_2)))
                .addItem(new BottomBarTab(mContext, R.mipmap.ic_perm_identity_grey_400_18dp, getString(R.string.main_tab_3)))
                .addItem(new BottomBarTab(mContext, R.mipmap.ic_perm_identity_grey_400_18dp, getString(R.string.main_tab_4)));
    }

    @Override
    protected void initData()
    {
        super.initData();
    }

    @Override
    protected void initEvents()
    {
        super.initEvents();
        mBinding.bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(int position, int prePosition)
            {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position)
            {

            }

            @Override
            public void onTabReselected(int position)
            {

            }
        });


    }

    private void requestCamera()
    {
    }

    @Override
    public void action2createLoanByInput()
    {
    }


    private void initFragment(Bundle savedInstanceState)
    {
        if (savedInstanceState == null)
        {
            mFragments[FIRST] = MissionFragment.create();
            mFragments[SECOND] = ThrowLoanFragment.create();
            mFragments[THIRD] = PickUpFragment.create();
            mFragments[FOUR] = MineFragment.create();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOUR]);
        } else
        {
            mFragments[FIRST] = findFragment(MissionFragment.class);
            mFragments[SECOND] = findFragment(ThrowLoanFragment.class);
            mFragments[THIRD] = findFragment(PickUpFragment.class);
            mFragments[FOUR] = findFragment(MineFragment.class);
        }
    }

    private long exitTime = 0;

    @Override
    public void onBackPressedSupport()
    {
        if ((System.currentTimeMillis() - exitTime) > 2000)
        {
            toast(getString(R.string.again_exit));
            exitTime = System.currentTimeMillis();
        } else
        {
            exit();
            System.exit(0);
        }
    }

    private void exit()
    {
        ActivityCollector.finishAll();
    }
}
