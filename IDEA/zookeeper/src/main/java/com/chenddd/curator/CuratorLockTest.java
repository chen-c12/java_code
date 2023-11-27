package com.chenddd.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
* Author: chenddd
* Date: 2022/4/4 11:18
* FileName: CuratorLockTest
* Description: CuratorLockTest
*/
public class CuratorLockTest {
    public static void main(String[] args) {
        //�����ֲ�ʽ��1
        InterProcessMutex lock1 = new InterProcessMutex(getCuratorFramework(), "/locks");
        //�����ֲ�ʽ��2
        InterProcessMutex lock2 = new InterProcessMutex(getCuratorFramework(), "/locks");

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    lock1.acquire();
                    System.out.println("�߳�1 ��ȡ����");
                    lock1.acquire();
                    System.out.println("�߳�1 �ٴλ�ȡ����");
                    Thread.sleep(5*1000);
                    lock1.release();
                    System.out.println("�߳�1�ͷ���");
                    lock1.release();
                    System.out.println("�߳�1�ٴ��ͷ���");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();



        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    lock2.acquire();
                    System.out.println("�߳�2 ��ȡ����");
                    lock2.acquire();
                    System.out.println("�߳�2 �ٴλ�ȡ����");
                    Thread.sleep(5*1000);
                    lock2.release();
                    System.out.println("�߳�2�ͷ���");
                    lock2.release();
                    System.out.println("�߳�2�ٴ��ͷ���");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static CuratorFramework getCuratorFramework() {
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(3000, 3);

        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("hadoop001:2181,hadoop002:2181,hadoop003:2181")
                .connectionTimeoutMs(2000)
                .sessionTimeoutMs(2000)
                .retryPolicy(policy)
                .build();

        //�����ͻ���
        client.start();
        System.out.println("�����ɹ���");
        return client;
    }
}
