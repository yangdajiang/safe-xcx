package com.cs.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by 15114 on 2018/6/10.
 */
public class Code {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String openId;
    private String SessionKey;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String sessionKey) {
        SessionKey = sessionKey;
    }

}
