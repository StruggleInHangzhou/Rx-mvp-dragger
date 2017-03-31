package com.jiahua.memory.other;

import android.os.Environment;

import java.io.File;

/**
 * Created by jhhuang on 2017/2/22.
 * QQ:781913268
 * Description：应用配置信息
 */
public class Config
{
    /**
     * 点击防抖动  单位毫秒
     */
    public static final int TIME_THROTTLE = 2000;
    /**
     * text改变响应 单位毫秒
     */
    public static final int TIME_DEBOUNCE = 500;
    /**
     * MD5加密
     */
    public static final String KEY = "16c946263f679ebdb6877a2272013b";
    /**
     * token
     */
    public static final String TOKEN = "token";

    public static final String UUID = "uuid";
    public static final String DEVICE_ID = "deviceId";
    public static final String KEY_AES = "aesKey";
    public static final String KEY_DEVICE = "deviceKey";

    public final static String DEFAULT_SAVE_FILE_PATH = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "loan"
            + File.separator
            + "download"
            + File.separator;
}