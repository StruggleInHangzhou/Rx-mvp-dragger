package com.jiahua.memory.rx_mvp_dragger;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.jakewharton.rxbinding.view.RxView;
import com.jiahua.db.bean.User;
import com.jiahua.memory.rx_mvp_dragger.adapter.UserAdapter;
import com.jiahua.memory.rx_mvp_dragger.core.BaseActivity;
import com.jiahua.memory.rx_mvp_dragger.databinding.ActivityMainBinding;
import com.jiahua.memory.rx_mvp_dragger.other.Config;
import com.jiahua.memory.rx_mvp_dragger.ui.activity.presenter.MainPresenter;
import com.jiahua.memory.rx_mvp_dragger.ui.contract.MainContract;
import com.jiahua.memory.rx_mvp_dragger.utils.Utils;
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

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = new AMapLocationClientOption();

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
        initLoaction();
        mUserList = new ArrayList<>();
        mUserAdapter = new UserAdapter(mContext, R.layout.item_user, mUserList);
        mBinding.rvUser.setLayoutManager(new LinearLayoutManager(mContext));
        mBinding.rvUser.setAdapter(mUserAdapter);
        new Thread()
        {
            @Override
            public void run()
            {
                super.run();
                try
                {
                    Looper.prepare();
                    sleep(5000);
                    Toast.makeText(mContext, "子线程", Toast.LENGTH_LONG).show();
                    Looper.loop();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void initLoaction()
    {
        //初始化client
        locationClient = new AMapLocationClient(this.getApplicationContext());
        //设置定位参数
        locationClient.setLocationOption(getDefaultOption());
        // 设置定位监听
        locationClient.setLocationListener(locationListener);
    }

    /**
     * 定位监听
     */
    AMapLocationListener locationListener = new AMapLocationListener()
    {
        @Override
        public void onLocationChanged(AMapLocation loc)
        {
            if (null != loc)
            {
                //解析定位结果
                String result = Utils.getLocationStr(loc);
                Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
            } else
            {
                Toast.makeText(mContext, "没有获取定位结果", Toast.LENGTH_LONG).show();
            }
        }
    };

    /**
     * 开始定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void startLocation()
    {
        //根据控件的选择，重新设置定位参数
        resetOption();
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
    }

    // 根据控件的选择，重新设置定位参数
    private void resetOption()
    {
        // 设置是否需要显示地址信息
        locationOption.setNeedAddress(true);
        /**
         * 设置是否优先返回GPS定位结果，如果30秒内GPS没有返回定位结果则进行网络定位
         * 注意：只有在高精度模式下的单次定位有效，其他方式无效
         */
        locationOption.setGpsFirst(true);
        // 设置是否开启缓存
        locationOption.setLocationCacheEnable(true);
        // 设置是否单次定位
        locationOption.setOnceLocation(true);
        //设置是否等待设备wifi刷新，如果设置为true,会自动变为单次定位，持续定位时不要使用
        locationOption.setOnceLocationLatest(true);
        //设置是否使用传感器
        locationOption.setSensorEnable(true);
        //设置是否开启wifi扫描，如果设置为false时同时会停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
//        String strInterval = etInterval.getText().toString();
//        if (!TextUtils.isEmpty(strInterval)) {
        try
        {
            // 设置发送定位请求的时间间隔,最小值为1000，如果小于1000，按照1000算
            locationOption.setInterval(2000);
        } catch (Throwable e)
        {
            e.printStackTrace();
        }
//        }

//        String strTimeout = etHttpTimeout.getText().toString();
//        if(!TextUtils.isEmpty(strTimeout)){
        try
        {
            // 设置网络请求超时时间
            locationOption.setHttpTimeOut(100000);
        } catch (Throwable e)
        {
            e.printStackTrace();
        }
//        }
    }

    /**
     * 默认的定位参数
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private AMapLocationClientOption getDefaultOption()
    {
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(false);//可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        return mOption;
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
                if (flag)
                {
                    stopLocation();
                } else
                {
                    startLocation();
                }
                flag = !flag;

                return true;
            }
        });
    }

    /**
     * 停止定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void stopLocation()
    {
        // 停止定位
        locationClient.stopLocation();
    }

    boolean flag = false;

    @Override
    public void notifyAdater(List<User> list)
    {
        mUserList.addAll(list);
        mUserAdapter.notifyDataSetChanged();
    }
}
