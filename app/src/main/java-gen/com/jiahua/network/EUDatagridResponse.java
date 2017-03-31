package com.jiahua.network;

import java.util.List;

/**
 * Created by jhhuang on 2016/11/22.
 * QQ:781913268
 * Description：Easyui表格响应结构
 */
public class EUDatagridResponse<T>
{
    private static final String TAG = "EUDatagridResponse";
    private Integer total;
    private List<T> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
