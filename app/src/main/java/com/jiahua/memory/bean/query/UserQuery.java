package com.jiahua.memory.bean.query;


import com.jiahua.base.BaseQuery;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by jhhuang on 2017/3/9
 * QQ:781913268
 * Description：传往服务端的具体参数
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQuery extends BaseQuery
{
    private String mobile;

    private String password;

    private String code;

}
