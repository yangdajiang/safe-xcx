package com.cs.pojo;

import javax.validation.constraints.NotNull;

/**
 *
 * Created by 15114 on 2018/6/10.
 * 参数符合小程序规范
 *
 */
public class Parameter {

    @NotNull(message = "参数不能为空")
    private String appid;
    @NotNull(message = "参数不能为空")
    private String secret;
    @NotNull(message = "参数不能为空")
    private String js_code;
    @NotNull(message = "参数不能为空")
    private String grant_type;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getJs_code() {
        return js_code;
    }

    public void setJs_code(String js_code) {
        this.js_code = js_code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
