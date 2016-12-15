package com.jiahua.memory.rx_mvp_dragger.network;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jhhuang on 2016/9/21.
 * QQ:781913268
 * Description：客户端管理类
 */
public class ClientManager
{
    private static final String TAG = "ClientManager";
    private static Map<String, AppClient> clientMap = new HashMap<>();


    private ClientManager()
    {

    }

    public static AppClient getClient(String url)
    {
        AppClient appClient;
        appClient = clientMap.get(url);

        if (appClient == null)
        {
            try
            {
                appClient = new AppClient(url);
            } catch (Exception e)
            {
                appClient = new AppClient();
                e.printStackTrace();
            }
            clientMap.put(url, appClient);
        }

        return appClient;
    }

    public static void registerClient(String url)
    {
        if (!clientMap.containsKey(url))
        {
            AppClient client = new AppClient(url);
            clientMap.put(url, client);
        }
    }

}
