package com.jiahua.constant;

/**
 * Created by jiahua on 17-2-25.
 * QQ:781913268
 * Description：平台
 */

public enum PlatformEnum
{
    APP_IOS(1,"IOS"),
    APP_ANDROID(2,"ANDROID"),
    APP_WINDOWSPHONE(4,"wp"),
    APP_SYMBIAN(7,"塞班"),
    APP_BLACKBERRYOS(8,"黑莓");

    private Integer value;
    private String desc;

    PlatformEnum(Integer value, String desc)
    {
        this.value = value;
        this.desc = desc;
    }

    public static PlatformEnum findByValue(Integer type)
    {
        for (PlatformEnum e : PlatformEnum.values())
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
