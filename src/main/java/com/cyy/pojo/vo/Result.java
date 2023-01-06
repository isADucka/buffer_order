package com.cyy.pojo.vo;


import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:40
 */
@Data
public class Result {
    /**
     * 编码
     * 1表示成功；0表示失败
     */
    private Integer code;

    /**
     * 信息描述
     */
    private String msg;

    /**
     * 返回的数据
     */
    private Map<String,Object> date;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, Map<String, Object> date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    /**
     * 没有返回数据的成功
     * @param message 附属信息
     * @return Result
     */
    public static Result succeed(String message){
        return  new Result(1,message);
    }

    /***
     * 没有返回数据的失败
     * @param message  附属信息
     * @return Result
     */
    public static Result error(String message){
        return new Result(0,message);
    }

    /**
     * 有信息，有数据 成功
     * @param message 信息
     * @param key 数据描述
     * @param value 数据
     * @return Result
     */
    public static Result succeedAndaddDate(String message,String key,Object value){
        Map<String,Object> map=new HashMap<>();
        map.put(key,value);
        return  new Result(1,message,map);

    }


    /**
     * 有信息，有数据 失败
     * @param message 信息
     * @param key 数据描述
     * @param value 数据
     * @return Result
     */
    public static Result errorAndaddDate(String message,String key,Object value){
        Map<String,Object> map=new HashMap<>();
        map.put(key,value);
        return  new Result(0,message,map);
    }
}
