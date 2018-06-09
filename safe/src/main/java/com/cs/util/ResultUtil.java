package com.cs.util;

import com.cs.pojo.ResultPojo;

/**
 * Created by 15114 on 2018/6/5.
 */
public class ResultUtil {

    public static ResultPojo result(int code, String msg, Object map){
        ResultPojo resultPojo = new ResultPojo();
        resultPojo.setCode(code);
        resultPojo.setMsg(msg);
        resultPojo.setData(map);
        return resultPojo;
    }

}
