package com.jun;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * @author 金鱼
 * @title: ThreadLocalTest
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1714:04
 */
public class ThreadLocalTest {

/*
    线程安全的map
*/
    public final static Map<String,Object> data = new Hashtable<>();

    private static Random random = new Random();

    public static class Task implements Runnable{

        @Override
        public void run() {

            //在run方法中，随机生成一个变量（线程要关联的数据），然后以当前线程为key保存到map中
            int i = random.nextInt(1000);
            String name = Thread.currentThread().getName();
            System.out.println("线程【"+name+"】生成的随机数是："+i);
            data.put(name, i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //在Run方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出朝左
            Object o = data.get(name);
            System.out.println("在线程【"+name +"】快结束时取出关联的数据是"+o);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }

}
