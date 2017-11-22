package com.lsw.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CollectionExample.testHashMap();
        CollectionExample.testLinkedHashMap();

        CollectionExample.testHashMapMemory();
        CollectionExample.testSparseArrayMemory();
        CollectionExample.testArrayMapMemory();


        String s11 = "a";
        String s12 = "a";

        boolean is = (s11 == s12);

        Log.i("lsw---",is+"");

        String s = new String("Hello");
        String s1 = s.intern();

        Log.i("lsw---s = ",(s == s1)+"");

        Log.i("lsw---float = ",(0.1*3 == 0.3)+"");

        //删除List集合元素
        ArrayList<String> originalList = new ArrayList<String>();
        originalList.add("1");
        originalList.add("2");
        originalList.add("2");
        originalList.add("4");
        originalList.add("3");
        originalList.add("7");
        //错误删除1
//        List<String> removeList = CollectionExample.wrongRemoveListElement(originalList,"2");

        //错误删除2
//        List<String> removeList = CollectionExample.wrongRemoveListElement2(originalList,"2");
        //正确删除
        List<String> removeList = CollectionExample.rightRemoveListElement(originalList,"2");
        Log.i("lsw----removeList = ",removeList.toString());

        //删除Map集合元素
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(i,"value"+i);
        }

//        Map<Integer,String> removeMap = CollectionExample.wrongRemoveMapElement(map);
        //正确删除Map集合元素
        Map<Integer,String> removeMap = CollectionExample.rightRemoveMapElement(map);
        Log.i("lsw----removeMap = ",removeMap.toString());

        //多个线程操作List（错误操作）
//        ArrayList<String> originalOperateList = new ArrayList<String>();
        //正确操作，因为CopyOnWriteArrayList是线程安全的
        /*CopyOnWriteArrayList<String> originalOperateList = new CopyOnWriteArrayList<String>();
        originalList.add("1");
        originalList.add("2");
        originalList.add("2");
        originalList.add("4");
        originalList.add("3");
        originalList.add("7");
        List<String> OperateList = CollectionExample.wrongMultiThreadOperateElement(originalOperateList);
        Log.i("lsw----OperateList = ",OperateList.toString());*/
        transientExampleTest();
    }


    private void transientExampleTest(){
        TransientExample logInfo = new TransientExample("MIKE", "MECHANICS");
        Log.i("lsw-transientExample1 ",logInfo.getExample());
        try {
            ObjectOutputStream o = new ObjectOutputStream(
                    new FileOutputStream("logInfo.out"));
            o.writeObject(logInfo);
            o.close();
        } catch(Exception e) {
            //deal with exception
        }
        //To read the object back, we can write
        try {
            ObjectInputStream in =new ObjectInputStream(
                    new FileInputStream("logInfo.out"));
            TransientExample logInfoIn = (TransientExample)in.readObject();
            Log.i("lsw-transientExample2 ",logInfo.getExample());
        } catch(Exception e) {
            //deal with exception
        }
    }

}
