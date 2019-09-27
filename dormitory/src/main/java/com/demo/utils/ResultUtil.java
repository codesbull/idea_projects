package com.demo.utils;

import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.common.RspEnum;

import java.util.HashMap;

public class ResultUtil {

    public static Result getResult(RspEnum rspEnum) {
        return getResult(rspEnum, new HashMap<>(0));
    }

    public static <T> Result getResult(RspEnum rspEnum, T data) {
        Result result = new Result();
        result.setMsg(rspEnum.getMsg());
        result.setCode(rspEnum.getCode());
        result.setData(data);
        return result;
    }

    public static PageResult getPageResult(RspEnum rspEnum) {
        return getPageResult(rspEnum, new HashMap<>(0),0);
    }


    public static <T> PageResult getPageResult(RspEnum rspEnum, T data,int count){
        PageResult pageResult=new PageResult();
        pageResult.setMsg(rspEnum.getMsg());
        pageResult.setCode(rspEnum.getCode());
        pageResult.setData(data);
        pageResult.setCount(count);
        return  pageResult;
    }

}
