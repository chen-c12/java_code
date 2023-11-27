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
        //1.��ȡzk����
        server.getConnect();
        //2. ע���������zk��Ⱥ
        server.regist(args[0]);
        //3.����ҵ���߼�
        server.business();

    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostname) throws KeeperException, InterruptedException {
        zkClient.create("/server/"+hostname, hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("hostname::"+hostname+"�Ѿ����ߣ�");
    }

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }
}
