package com.cs.util;

import com.aliyuncs.exceptions.ClientException;
import com.cs.pojo.User;

import java.util.TimerTask;

import static com.cs.service.TimeService.ints;

/**
 * Created by 15114 on 2018/6/6.
 */
public class TimeUtil2 extends TimerTask {

    private int i;
    private User user;
    public TimeUtil2(int i,User user){
        this.i = i;
        this.user = user;
    }

    @Override
    public void run() {

        try {
            SendMessUtil.sendFriendsMess(
                    user.getUserName(),
                    user.getPhone1(),
                    user.getPhone2(),
                    user.getPhone3(),
                    user.getNowPlace()
            );
            this.cancel();
            ints[i] = 0;
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
