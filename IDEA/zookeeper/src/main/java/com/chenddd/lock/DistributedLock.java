package com.chenddd.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
* Author: chenddd
* Date: 2022/4/3 16:23
* FileName: DistributedLock
* Description: zookeeper distributedLock test
*/
public class DistributedLock {
    private final String connectString = "hadoop001:2181,hadoop002:2181,hadoop003:2181";
    private final int sessionTimeout = 2000;
    private final ZooKeeper zk;

    private CountDownLatch connectLatch = new CountDownLatch(1);
    public CountDownLatch waitLatch = new CountDownLatch(1);
    private String waitPath;
    private String currentMode;


    public DistributedLock() throws IOException, InterruptedException, KeeperException {

        //��ȡ����
         zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                //connectLatch  ���������zk �����ͷ�
                if (event.getState() == Event.KeeperState.SyncConnected){
                    connectLatch.countDown();
                }
                //waitLatch ��Ҫ�ͷ�
                if (event.getType() == Event.EventType.NodeDeleted && event.getPath().equals(waitPath)){
                    waitLatch.countDown();
                }
            }
        });

         //�ȴ�zk�������Ӻ������߳���
         connectLatch.await();

        //�жϸ��ڵ�/locks�Ƿ����
        Stat stat = zk.exists("/locks", false);
        if (stat == null){
            //��Ҫ�������ڵ�
            zk.create("/locks", "locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    ///��zk����
    public void zkLock(){
        //������Ӧ����ʱ����Žڵ�
        try {
            currentMode = zk.create("/locks/" + "seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            //�жϴ����Ľڵ��Ƿ�����С����Žڵ㣬����ǻ�ȡ������������ǣ��������ǰһ���ڵ�
            List<String> children = zk.getChildren("/locks", false);

            //���childrenֻ��һ��ֵ���Ǿ�ֱ�ӻ�ȡ�����������ڵ���Ҫ�жϣ�˭��С
            if (children.size() == 1){
                return;
            }else {
                Collections.sort(children);

                //��ȡ�ڵ�����seq-00000000
                String thisNode = currentMode.substring("/locks/".length());
                //ͨ��seq-00000000��ȡ�Ľڵ���children���ϵ�λ��
                int index = children.indexOf(thisNode);

                //�ж�
                if (index == -1){
                    System.out.println("�����쳣");
                }else if(index == 0){
                    //��һ���ڵ���Ի�ȡ��
                    return;
                }else {
                    //��Ҫ����ǰһ���ڵ�
                    waitPath = "/locks/"+children.get(index-1);
                    zk.getData(waitPath,true,null);

                    //�ȴ�����
                    waitLatch.await();

                    return;
                }
            }

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //����
    public void unlock(){
        //ɾ���ڵ�
        try {
            zk.delete(currentMode, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }
}
