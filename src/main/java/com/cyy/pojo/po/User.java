package com.cyy.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:21
 */
@Data
@TableName("tb1_user")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer  userId;

    private String phone;

    private String password;

    private Double money;
}
