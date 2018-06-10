package com.cs.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cs.pojo.Code;
import com.cs.pojo.Parameter;
import com.cs.pojo.ResultPojo;
import com.cs.pojo.User;
import com.cs.service.UserService;
import com.cs.util.ResultUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;

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

    @RequestMapping(path = "/getOpenId" )
    public ResultPojo getOpenId(@RequestBody @Valid Parameter parameter ,BindingResult bindingResult) throws URISyntaxException, IOException {
        ResultPojo resultPojo;

        if(bindingResult.hasErrors()){
            resultPojo =
                    ResultUtil.result(-1,
                            bindingResult.getFieldError().getDefaultMessage(),
                            null);
            return resultPojo;
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder("https://api.weixin.qq.com/sns/jscode2session");

        uriBuilder.addParameter("appid", parameter.getAppid());
        uriBuilder.addParameter("secret", parameter.getSecret());
        uriBuilder.addParameter("js_code", parameter.getJs_code());
        uriBuilder.addParameter("grant_type", parameter.getGrant_type());

        HttpGet get = new HttpGet(uriBuilder.build());
        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity httpEntity = response.getEntity();
        if (httpEntity != null) {
            String context = EntityUtils.toString(httpEntity);
            JSONObject jsonObject = JSON.parseObject(context);
            if (jsonObject.containsKey("openid")) {
                Code code = new Code();
                code.setOpenId(jsonObject.getString("openid"));
                code.setSessionKey(jsonObject.getString("session_key"));
                resultPojo = ResultUtil.result(0, "请求成功", code);
                return resultPojo;
            }
        }
        resultPojo = ResultUtil.result(-1, "请求失败", null);
        return resultPojo;
    }

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
