package com.chenddd.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ½ðÓã
 * @title: JedisClusterTest
 * @projectName jedis_redis
 * @description: Á¬½ÓJedis-Cluster
 * @date 2022/3/28 22:35
 */

public class JedisClusterTest {
    public static void main(String[] args) throws IOException {
        /*Set<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("192.168.184.150",6381));*/
        HostAndPort hostAndPort = new HostAndPort("192.168.184.150", 6381);
        JedisCluster jedisCluster = new JedisCluster(hostAndPort);
//        jedisCluster.set("k1", "v1");
        System.out.println(jedisCluster.get("k12"));
        jedisCluster.close();
    }
}
