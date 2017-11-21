package com.lsw.demo;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liushuwei on 2017/5/24.
 */

public class CollectionExample {

    private static final String TAG = "CollectionExample";

    /**
     * for循环遍历list
     * 删除某个元素后，list的大小发生了变化，而你的索引也在变化，所以会导致你在遍历的时候漏掉某些元素
     * @param list
     * @param key
     * @return
     */
    public static List<String> wrongRemoveListElement(List<String> list, String key) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(key))
                list.remove(i);
        }
        return list;

    }

    /**
     *删除元素后继续循环会报错误信息ConcurrentModificationException
     * @param list
     * @param key
     * @return
     */
    public static List<String> wrongRemoveListElement2(List<String> list, String key) {
        for(String str:list){
            if(str.equals(key))
                list.remove(str);
        }
        return list;

    }

    /**
     * 正确删除List几个元素
     * @param list
     * @param key
     * @return
     */
    public static List<String> rightRemoveListElement(List<String> list, String key) {

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = (String) iterator.next();
            if (value.equals(key)) {
                iterator.remove();
            }
        }
        return list;

    }


    /**
     * 遍历删除元素会报错误信息ConcurrentModificationException
     * 错误删除map中的元素
     * @param map
     * @return
     */
    public static Map<Integer, String> wrongRemoveMapElement(Map<Integer, String> map) {

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (key % 2 == 0) {
                map.remove(key);
            }
        }
        return map;

    }

    /**
     * 正确删除map中的元素
     * @param map
     * @return
     */
    public static Map<Integer, String> rightRemoveMapElement(Map<Integer, String> map) {

        List<Integer> delList = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (key % 2 == 0) {
                delList.add(key);
            }
        }

        for (int i = 0; i < delList.size(); i++) {
            map.remove(delList.get(i));
        }

        return map;

    }

    public static List<String> wrongMultiThreadOperateElement(final List<String> list) {

        //第一个线程遍历List
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        Log.i("lsw---",(String) iterator.next());
                    }
                }
            }
        }).start();

        //第二个线程增加元素
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for(int i=101;i<200;i++){
                        list.add(i+"");
                    }
                }
            }
        }).start();


        return list;

    }

    public static void testHashMap(){

        HashMap map = new HashMap();

        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Log.i(TAG, "testHashMap: " + iterator.next());
        }

    }

    public static void testLinkedHashMap(){

        LinkedHashMap map = new LinkedHashMap();

        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Log.i(TAG, "testLinkedHashMap: " + iterator.next());
        }

        map = new LinkedHashMap<String, String>(10, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.get("2");//2移动到了内部的链表末尾
        map.get("4");//4调整至末尾
        map.put("3", "e");//3调整至末尾
        map.put(null, null);//插入两个新的节点 null
        map.put("5", null);//5
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Log.i(TAG, "testLinkedHashMap2: " + iterator.next());
        }


    }


}
