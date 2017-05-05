package com.lsw.demo;

import android.util.Log;

/**
 * Created by liushuwei on 2017/5/5.
 */

public class Out {

    private int age;

     class In{
        public void test(){
            Log.i("lsw---","In"+age);
        }
    }

    static class SIn{
        public void sTest(){
            Log.i("lsw---","SIn");
        }
    }

    static void fun(){
        final int i = 0;
        class test1{
            void test2(){
                Log.i("lsw---","SIn"+i);
            }
        }
    }
}
