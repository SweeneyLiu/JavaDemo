package com.lsw.demo;

import android.util.Log;

/**
 * Created by liushuwei on 2017/5/5.
 */

public class Test extends Data{
    void getName(){
        Log.i("lsw---",super.getClass().getName());
    }

    int getNum() {
        try {
            int a = 1 / 0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    int getNum2() {
        int a = 1;
        try {
            return a;
        } catch (Exception e) {
            return 2;
        } finally {
            a++;
        }
    }

}
