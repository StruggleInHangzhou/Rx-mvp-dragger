package com.jiahua.base;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by jhhuang on 17-3-6
 * QQ:781913268
 * Description：xxx
 */
@Data
public abstract class BaseDTO implements Serializable, Cloneable
{
    protected Integer id;     //唯一ID
    protected Integer version;        //数据版本号
    protected String remark;        //备注
    protected String key;       //密钥

    public BaseDTO clone()
    {
        try
        {
            return (BaseDTO) super.clone();
        } catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
}
