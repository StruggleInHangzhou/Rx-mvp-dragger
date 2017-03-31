package com.jiahua.base;

import java.util.Date;
import java.util.List;

/**
 * Created by jhhuang on 17-3-7
 * QQ:781913268
 * Description：xxx
 */

public abstract class BaseQuery
{
    protected Integer id;     //唯一ID
    protected Integer version = 1;        //数据版本号
    protected String remark;        //备注
    protected Date createAt;         //创建时间
    protected Long stateflag;       //数据状态
    protected String orderDesc = "DESC";       //排序方向
    protected boolean isOrder;      //是否排序
    protected List orderBy;       //排序列表
    protected String key;       //密钥

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Date getCreateAt()
    {
        return createAt;
    }

    public void setCreateAt(Date createAt)
    {
        this.createAt = createAt;
    }

    public Long getStateflag()
    {
        return stateflag;
    }

    public void setStateflag(Long stateflag)
    {
        this.stateflag = stateflag;
    }

    public String getOrderDesc()
    {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc)
    {
        this.orderDesc = orderDesc;
    }

    public boolean isOrder()
    {
        return isOrder;
    }

    public void setOrder(boolean order)
    {
        isOrder = order;
    }

    public List getOrderBy()
    {
        return orderBy;
    }

    public void setOrderBy(List orderBy)
    {
        this.orderBy = orderBy;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
