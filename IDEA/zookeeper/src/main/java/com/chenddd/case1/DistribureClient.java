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
        //获取zk连接
        client.getConnect();
        //监听/server下面子节点增加和删除
        client.getServerList();
        //业务逻辑
        client.business();

    }

    private void business() throws InterruptedException {
        System.out.println("client is working ...");
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getServerList() throws KeeperException, InterruptedException {
        //1.获取服务器子节点信息，并且对父节点进行监听
        List<String> children = zkClient.getChildren(parentNode, true);

        //2.存储服务器信息列表
        ArrayList<String> servers = new ArrayList<>();

        //3.遍历所有节点，获取节点中的主机名称信息
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
