package com.jiahua.network.ex;



/**
 * Created by jhhuang on 2016/9/19.
 * QQ:781913268
 * Description：联网约定异常
 */
public class ApiException extends RuntimeException
{
    public ApiException(String detailMessage)
    {
        super(detailMessage);
    }

    public ApiException()
    {
        super();
    }

    public ApiException(Throwable throwable)
    {
        super(throwable);
    }

    public ApiException(String detailMessage, Throwable throwable)
    {
        super(detailMessage, throwable);
    }

}
