package com.cyy.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Map;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:24
 */
@Data
@TableName("tb3_order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer orderId;

    private Integer userId;

    private LocalDate start;

    private Integer status;

    private String details;

    private Double pay;

    @TableField(exist = false)
    private Map<String,Integer> orderDetails;
}
