package com.jiahua.memory.adapter;

import android.content.Context;

import com.jiahua.memory.bean.LoanEntiy;
import com.jiahuaandroid.basetools.adapter.recyclerview.CommonAdapter;
import com.jiahuaandroid.basetools.adapter.recyclerview.base.ViewHolder;

import java.util.List;


/**
 * Created by jhhuang on 2017/3/13
 * QQ:781913268
 * Description：xxx
 */
public class LoanAdapter extends CommonAdapter<LoanEntiy>
{
    public LoanAdapter(Context context, int layoutId, List<LoanEntiy> datas)
    {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, LoanEntiy loanEntiy, int position)
    {
        String userInfo = loanEntiy.getUserName()+" "+loanEntiy.getAge()+"岁 "+loanEntiy.getMarriageType()+" "+loanEntiy.getCompanyType()+" "+loanEntiy.getCompanyJob();
//        holder.setText(R.id.tv_user_info,userInfo);
//        holder.setText(R.id.tv_loan_type,loanEntiy.getLoanType());
//        holder.setText(R.id.tv_loan_area,mContext.getString(R.string.loan_area_dec)+loanEntiy.getLoanType());
//        holder.setText(R.id.tv_loan_user_way,loanEntiy.getLaonUseWay());
//        holder.setText(R.id.loan_amount,loanEntiy.getLoanAmount());
//        holder.setText(R.id.loan_interest,loanEntiy.getLoanInterest());
//        holder.setText(R.id.loan_limit,loanEntiy.getLoanLimit());
//        holder.setText(R.id.loan_refund,loanEntiy.getLoanRefund());
    }
}
