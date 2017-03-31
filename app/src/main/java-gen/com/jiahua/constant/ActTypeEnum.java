package com.jiahua.constant;

/**
 * Created by jiahua on 17-2-25.
 * QQ:781913268
 * Description：
 */

public enum ActTypeEnum
{
    ACTION_LOGIN_CODE(101,"获取登录短信验证码");

    private Integer value;
    private String desc;

    ActTypeEnum(Integer value, String desc)
    {
        this.value = value;
        this.desc = desc;
    }

    public static ActTypeEnum findByValue(Integer type)
    {
        for (ActTypeEnum e : ActTypeEnum.values())
        {
            if(type == e.getValue()) {
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
