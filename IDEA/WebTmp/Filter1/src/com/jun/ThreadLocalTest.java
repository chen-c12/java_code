package com.jun;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * @author ����
 * @title: ThreadLocalTest
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1714:04
 */
public class ThreadLocalTest {

/*
    �̰߳�ȫ��map
*/
    public final static Map<String,Object> data = new Hashtable<>();

    private static Random random = new Random();

    public static class Task implements Runnable{

        @Override
        public void run() {

            //��run�����У��������һ���������߳�Ҫ���������ݣ���Ȼ���Ե�ǰ�߳�Ϊkey���浽map��
            int i = random.nextInt(1000);
            String name = Thread.currentThread().getName();
            System.out.println("�̡߳�"+name+"�����ɵ�������ǣ�"+i);
            data.put(name, i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //��Run��������֮ǰ���Ե�ǰ�߳�����ȡ�����ݲ���ӡ���鿴�Ƿ����ȡ������
            Object o = data.get(name);
            System.out.println("���̡߳�"+name +"�������ʱȡ��������������"+o);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }

}
