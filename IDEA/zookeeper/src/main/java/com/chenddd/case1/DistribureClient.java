package com.chenddd.case1;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Author: chenddd
* Date: 2022/4/2 19:54
* FileName: DistribureClient
* Description: DistribureClient
*/
public class DistribureClient {
    private String connectionString = "hadoop001:2181,hadoop002:2181,hadoop003:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;
    private String parentNode = "/server";
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistribureClient client = new DistribureClient();
        //��ȡzk����
        client.getConnect();
        //����/server�����ӽڵ����Ӻ�ɾ��
        client.getServerList();
        //ҵ���߼�
        client.business();

    }

    private void business() throws InterruptedException {
        System.out.println("client is working ...");
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getServerList() throws KeeperException, InterruptedException {
        //1.��ȡ�������ӽڵ���Ϣ�����ҶԸ��ڵ���м���
        List<String> children = zkClient.getChildren(parentNode, true);

        //2.�洢��������Ϣ�б�
        ArrayList<String> servers = new ArrayList<>();

        //3.�������нڵ㣬��ȡ�ڵ��е�����������Ϣ
        for (String child : children) {
            byte[] data = zkClient.getData(parentNode + "/" + child, false, null);
            servers.add(new String(data));
        }
        System.out.println(servers);
    }

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                try {
                    getServerList();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (KeeperException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
