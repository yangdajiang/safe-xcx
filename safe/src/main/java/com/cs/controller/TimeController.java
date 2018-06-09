package com.cs.controller;

import com.cs.pojo.ResultPojo;
import com.cs.service.TimeService;
import com.cs.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 15114 on 2018/6/5.
 */
@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    TimeService timeService;
    ResultPojo resultPojo;

    @RequestMapping(path = "/startTime",method = RequestMethod.POST)
    public ResultPojo startTime(@RequestParam(value = "open_id") String openId){
        if(openId.equals("")||openId==null){
            resultPojo = ResultUtil.result(-1,"参数不能为空",null);
            return resultPojo;
        }
        resultPojo = timeService.startTime(openId);
        return resultPojo;
    }

    @RequestMapping("/endTime")
    public ResultPojo endTime(@RequestParam(value = "tid") int tid){
        resultPojo = timeService.endTime(tid);
        return resultPojo;
    }

}
