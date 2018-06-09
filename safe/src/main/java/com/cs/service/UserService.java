package com.cs.service;

import com.cs.dao.UserMapper;
import com.cs.pojo.ResultPojo;
import com.cs.pojo.User;
import com.cs.service.impl.UserServiceImpl;
import com.cs.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 15114 on 2018/6/5.
 */
@Service
public class UserService implements UserServiceImpl{

    @Autowired
    UserMapper userMapper;

    @Override
    public ResultPojo first(String openId) {

        User user;
        ResultPojo resultPojo;
        user = userMapper.selectByOpenId(openId);
        if(user==null){
            resultPojo = ResultUtil.result(-1,"该用户为第一次登陆",null);
        }else {
            resultPojo = ResultUtil.result(0,"该用户数据已存在",null);
        }
        return resultPojo;
    }

    @Override
    public ResultPojo init(User user) {
        userMapper.insert(user);
        ResultPojo resultPojo = ResultUtil.result(
                0,
                "添加成功",
                null);
        return resultPojo;
    }

    @Override
    public ResultPojo updatePlace(String openId, String nowPlace) {

        ResultPojo resultPojo;
        if(userMapper.selectByOpenId(openId)==null){
            resultPojo = ResultUtil.result(-1,"用户不存在",null);
        }else {
            User user = userMapper.selectByOpenId(openId);
            user.setNowPlace(nowPlace);
            userMapper.updateByOpenId(user);
            resultPojo = ResultUtil.result(0,"修改成功",null);
        }
        return resultPojo;
    }

}