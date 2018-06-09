package com.cs.service.impl;

import com.cs.pojo.ResultPojo;

/**
 * Created by 15114 on 2018/6/5.
 */
public interface TimeServiceImpl {

    ResultPojo startTime(String openId);
    ResultPojo endTime(int i);

}
