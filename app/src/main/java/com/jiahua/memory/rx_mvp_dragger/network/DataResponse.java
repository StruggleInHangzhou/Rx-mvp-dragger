package com.jiahua.memory.rx_mvp_dragger.network;

/**
 * Created by jhhuang on 2016/9/19.
 * QQ:781913268
 * Description：返回的实体类泛型
 */
public class DataResponse<T>
{
    private int code;
    private String msg;
    private T data;

    public int getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }

    public T getData()
    {
        return data;
    }
}
