package com.jiahua.memory.bean.dto;


import com.jiahua.base.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by jhhuang on 2017/3/9
 * QQ:781913268
 * Description： 服务端返回实体对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO
{
    private String mobile;

    private String password;

    private String code;
}
