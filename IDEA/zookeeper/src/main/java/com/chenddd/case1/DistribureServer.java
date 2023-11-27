package com.chenddd.case1;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
* Author: chenddd
* Date: 2022/4/2 19:34
* FileName: DistribureServer
* Description: DistribureServer
*/
public class DistribureServer {
    private String connectionString = "hadoop001:2181,hadoop002:2181,hadoop003:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        DistribureServer server = new DistribureServer();
        //1.获取zk连接
        server.getConnect();
        //2. 注册服务器到zk集群
        server.regist(args[0]);
        //3.启动业务逻辑
        server.business();

    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostname) throws KeeperException, InterruptedException {
        zkClient.create("/server/"+hostname, hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("hostname::"+hostname+"已经上线！");
    }

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }
}
