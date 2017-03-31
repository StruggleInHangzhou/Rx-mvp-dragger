package com.jiahua.memory.adapter;

import android.content.Context;

import com.jiahua.memory.bean.LoanEntity;
import com.jiahuaandroid.basetools.adapter.recyclerview.CommonAdapter;
import com.jiahuaandroid.basetools.adapter.recyclerview.base.ViewHolder;

import java.util.List;


/**
 * Created by jhhuang on 2017/3/13
 * QQ:781913268
 * Description：xxx
 */
public class LoanAdapter extends CommonAdapter<LoanEntity>
{
    public LoanAdapter(Context context, int layoutId, List<LoanEntity> datas)
    {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, LoanEntity loanEntity, int position)
    {
        String userInfo = loanEntity.getUserName()+" "+ loanEntity.getAge()+"岁 "+ loanEntity.getMarriageType()+" "+ loanEntity.getCompanyType()+" "+ loanEntity.getCompanyJob();
//        holder.setText(R.id.tv_user_info,userInfo);
//        holder.setText(R.id.tv_loan_type,loanEntity.getLoanType());
//        holder.setText(R.id.tv_loan_area,mContext.getString(R.string.loan_area_dec)+loanEntity.getLoanType());
//        holder.setText(R.id.tv_loan_user_way,loanEntity.getLaonUseWay());
//        holder.setText(R.id.loan_amount,loanEntity.getLoanAmount());
//        holder.setText(R.id.loan_interest,loanEntity.getLoanInterest());
//        holder.setText(R.id.loan_limit,loanEntity.getLoanLimit());
//        holder.setText(R.id.loan_refund,loanEntity.getLoanRefund());
    }
}
