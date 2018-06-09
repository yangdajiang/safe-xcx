package com.cs.service;

import com.cs.dao.UserMapper;
import com.cs.pojo.ResultPojo;
import com.cs.service.impl.TimeServiceImpl;
import com.cs.util.ResultUtil;
import com.cs.util.TimeUtil1;
import com.cs.util.TimeUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;

/**
 * Created by 15114 on 2018/6/5.
 */
@Service
public class TimeService implements TimeServiceImpl {

    public static int[] ints =new int[20];
    Timer timer1 = new Timer();
    Timer timer2 = new Timer();
    TimeUtil1[] timeUtils1 = new TimeUtil1[20];
    TimeUtil2[] timeUtils2= new TimeUtil2[20];

    @Autowired
    UserMapper userMapper;

    @Override
    public ResultPojo startTime(String openId) {
        ResultPojo resultPojo;
        if(userMapper.selectByOpenId(openId)==null){
            resultPojo = ResultUtil.result(-1,"该用户信息不存在",null);
            return resultPojo;
        }
        for(int tid=0;tid<20;tid++){
            if(ints[tid]==0){
                ints[tid] = 1;
                timeUtils1[tid] = new TimeUtil1(tid,userMapper.selectByOpenId(openId));
                timeUtils2[tid] = new TimeUtil2(tid,userMapper.selectByOpenId(openId));
                timer1.schedule(timeUtils1[tid],600000);
                timer2.schedule(timeUtils2[tid],900000);
                resultPojo = ResultUtil.result(0,"计时线程分配成功",tid);
                return resultPojo;
            }
        }
        resultPojo = ResultUtil.result(-1,"线程分配失败，稍后再试",null);
        return resultPojo;
    }

    @Override
    public ResultPojo endTime(int tid) {
        ResultPojo resultPojo;
        if(!(tid>=0||tid<=20)){
            resultPojo = ResultUtil.result(-1,"超出线程数",null);
            return resultPojo;
        }
        if(ints[tid]==0){
            resultPojo = ResultUtil.result(-1,"此线程已在停止状态",null);
            return resultPojo;
        }
        timeUtils1[tid].cancel();
        timeUtils2[tid].cancel();
        ints[tid] = 0;
        resultPojo = ResultUtil.result(0,"线程停止成功",null);
        return resultPojo;
    }
}