package com.cs.controller;

import com.cs.pojo.ResultPojo;
import com.cs.pojo.User;
import com.cs.service.UserService;
import com.cs.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by 15114 on 2018/6/5.
 */

/**
 * code :-1
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/first" , method = RequestMethod.POST)
    public ResultPojo first(@RequestParam("open_id") String openId){
        ResultPojo resultPojo;
        if(openId == null || openId.equals("")){
            resultPojo = ResultUtil.result(
                    -1,
                    "参数不能为空",
                    null);
        }else {
            resultPojo = userService.first(openId);
        }
        return resultPojo;
    }

    @RequestMapping(path = "/init",method = RequestMethod.POST)
    public ResultPojo init(@RequestBody @Valid User user , BindingResult bindingResult){
        ResultPojo resultPojo;
        if(bindingResult.hasErrors()){
            resultPojo =
                    ResultUtil.result(-1,
                    bindingResult.getFieldError().getDefaultMessage(),
                    null);
        }else {
            resultPojo = userService.init(user);
        }
        return resultPojo;
    }

    @RequestMapping(path = "/updatePlace",method = RequestMethod.POST)
    public ResultPojo updatePlace(@RequestParam("open_id") String openId,
                                  @RequestParam("now_place") String nowPlace){
        ResultPojo resultPojo;
        if(openId == null || openId.equals("")
                || nowPlace == null || nowPlace.equals("")){
            resultPojo = ResultUtil.result(
                    -1,
                    "参数不能有空",
                    null);
        }else {
            resultPojo = userService.updatePlace(openId,nowPlace);
        }
        return resultPojo;
    }
}
