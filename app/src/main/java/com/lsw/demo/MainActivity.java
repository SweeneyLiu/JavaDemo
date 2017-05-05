package com.lsw.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Out.In in = new Out().new In();
        in.test();

        Out.SIn sin = new Out.SIn();
        sin.sTest();

        new Test().getName();
        Log.i("lsw---",new Test().getNum2()+"");
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1","zs");
//        hashMap.put("1","ww");
        Hashtable<String,String> hashtable = new Hashtable<String,String>();
//        hashtable.put(null,null);
        Log.i("lsw---",hashMap.get("1"));
        HashSet<String> set = new HashSet();
        String s1 = new String("11");
        String s2 = new String("11");
        Log.i("lsw---add1 = ",""+set.add(s1));
        Log.i("lsw---add2 = ",""+set.add(s2));
        Log.i("lsw---",set.size()+"");

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        list.add("4");
        list.add("5");
        Log.i("lsw----list = ",list.toString());
        HashSet<String> listSet = new HashSet(list);
        Log.i("lsw---set---",listSet.toString());
        List<String> newList = new ArrayList<>(listSet);
        Log.i("lsw----list = ",newList.toString());
    }
}
