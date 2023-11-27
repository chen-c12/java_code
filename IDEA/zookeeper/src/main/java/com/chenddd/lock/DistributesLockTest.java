package com.chenddd.lock;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/4 10:55
* FileName: DistributesLockTest
* Description: Test
*/
public class DistributesLockTest {
        public static void main(String[] args) throws
                InterruptedException, IOException, KeeperException {
            // �����ֲ�ʽ�� 1
            final DistributedLock lock1 = new DistributedLock();
            // �����ֲ�ʽ�� 2
            final DistributedLock lock2 = new DistributedLock();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // ��ȡ������
                    try {
                        lock1.zkLock();
                        System.out.println("�߳� 1 ��ȡ��");
                        Thread.sleep(5 * 1000);
                        lock1.unlock();
                        System.out.println("�߳� 1 �ͷ���");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // ��ȡ������
                    try {
                        lock2.zkLock();
                        System.out.println("�߳� 2 ��ȡ��");
                        Thread.sleep(5 * 1000);
                        lock2.unlock();
                        System.out.println("�߳� 2 �ͷ���");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
