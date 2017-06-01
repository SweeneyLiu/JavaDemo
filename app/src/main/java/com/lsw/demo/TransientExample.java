package com.lsw.demo;

import java.io.Serializable;

/**
 * Created by liushuwei on 2017/5/27.
 */

public class TransientExample implements Serializable{

    private String userName;
    private transient String password;

    public TransientExample(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getExample(){
        if(password == null){
            password = "no set";
        }
        return "logon info: \n   " + "user: " + userName +
                "\n   password: " + password;
    }

}
