package com.cs.service.impl;

import com.cs.pojo.ResultPojo;
import com.cs.pojo.User;

/**
 * Created by 15114 on 2018/6/5.
 */

public interface UserServiceImpl {
    ResultPojo first (String openId);
    ResultPojo init (User user);
    ResultPojo updatePlace (String openId,String nowPlace);
}

