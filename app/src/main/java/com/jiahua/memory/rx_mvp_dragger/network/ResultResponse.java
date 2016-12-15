package com.jiahua.memory.rx_mvp_dragger.network;

/**
 * Created by jhhuang on 2016/10/20.
 * QQ:781913268
 * Description：只有一个code值
 */
public class ResultResponse
{
    private static final String TAG = "ResultResponse";
    private int code = -1;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ResultResponse{" +
                "code='" + code + '\'' +
                '}';
    }
}
