package com.jiahua.memory.rx_mvp_dragger.adapter;

import android.content.Context;

import com.jiahua.db.bean.User;
import com.jiahua.memory.rx_mvp_dragger.R;
import com.jiahuaandroid.basetools.adapter.recyclerview.CommonAdapter;
import com.jiahuaandroid.basetools.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by jhhuang on 2016/12/14.
 * QQ:781913268
 * Description：UserAdapter
 */
public class UserAdapter extends CommonAdapter<User>
{

    public UserAdapter(Context context, int layoutId, List<User> datas)
    {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, User user, int position)
    {
        holder.setText(R.id.tv_name, user.getName());
        holder.setText(R.id.tv_age, String.valueOf(user.getAge()));

    }
}