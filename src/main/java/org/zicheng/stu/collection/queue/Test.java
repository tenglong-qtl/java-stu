package org.zicheng.stu.collection.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Author: zicheng
 * Since: 2020-10-11 21:25
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(1);

        for(Integer i : integerList){
            System.out.println(i);
        }
    }
}
