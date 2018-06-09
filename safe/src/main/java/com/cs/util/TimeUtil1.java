package com.cs.util;

import com.aliyuncs.exceptions.ClientException;
import com.cs.pojo.User;

import java.util.TimerTask;

/**
 * Created by 15114 on 2018/6/5.
 */
public class TimeUtil1 extends TimerTask{

    private int i;
    private User user;
    public TimeUtil1(int i,User user){
        this.i = i;
        this.user = user;
    }

    @Override
    public void run() {
        try {
            SendMessUtil.sendUserMess(user.getUserPhone());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        this.cancel();
    }

}
