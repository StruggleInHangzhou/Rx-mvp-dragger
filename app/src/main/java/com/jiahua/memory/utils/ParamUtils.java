package com.jiahua.memory.utils;

import android.text.TextUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jhhuang on 2017/3/19.
 * QQ:781913268
 * Description：xxx
 */
public class ParamUtils
{

    public static <T> Map<String, String> createMapForObject(T t)
    {
        Map<String, String> map = new HashMap<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields)
        {
            try
            {
                field.setAccessible(true);
                if (!TextUtils.isEmpty(field.get(t).toString()))
                {
                    map.put(field.getName(), field.get(t).toString());
                }

            } catch (Exception e)
            {
            }
        }
        return map;
    }

}
