package com.chenddd.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author chenddd
 * @title: ZookeeperClient
 * @projectName zookeeper
 * @description: zookeeper client
 * @date 2022/4/215:06
 */
public class ZookeeperClient {
    private String connectionString = "hadoop001:2181,hadoop002:2181,hadoop003:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("++++++++++++++++++++++++++++");
                for (String child : children) {
                    System.out.println(child);
                }
                System.out.println("============================");
            }
        });
    }

    /**
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void create() throws KeeperException, InterruptedException {
        zkClient.create("/chenddd", "chenaaaa".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void getChildren() throws KeeperException, InterruptedException {
        zkClient.getChildren("/", true);
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void exit() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/chenddd", false);

        System.out.println(stat ==null? "not exit":"exit");
    }
}
