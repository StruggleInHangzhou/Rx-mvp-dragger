package com.jiahua.constant;

/**
 * Created by jiahua on 17-2-25.
 * QQ:781913268
 * Description：发送短信类型
 */

public enum SendSMSEnum
{
    SMS_REGISTER(0, "register"),
    SMS_LOGIN_CODE(1, "验证码登录"),
    SMS_LOGIN_THIRD_PARTY(2, "第三方登录"),
    SMS_RETRIEVE_PASSWORD(3, "forget"),
    SMS_BINDING(4, "modify");

    private Integer value;
    private String desc;

    SendSMSEnum(Integer value, String desc)
    {
        this.value = value;
        this.desc = desc;
    }

    public static SendSMSEnum findByValue(Integer type)
    {
        for (SendSMSEnum e : SendSMSEnum.values())
        {
            if (type == e.getValue())
            {
                return e;
            }
        }
        return null;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}
