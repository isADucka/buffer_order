package com.cyy.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:11
 */
@Data
@TableName("tb2_food")
public class Food implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer foodId;

    private String foodName;

    private Double price;

    private Integer number;

    private String kind;

    private String description;

    private String picture;



}