package com.chenddd.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author 金鱼
 * @title: JedisDemo1
 * @projectName jedis_redis
 * @description: TODO
 * @date 2022/3/2310:56
 */
public class JedisDemo1 {

    private Jedis jedis(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.184.150",6379);
        return jedis;
    }

    /**
     * 查找key
     */
    @Test
    public void demo1(){
        Jedis jedis = jedis();
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
        jedis.close();
    }
    @Test
    public void demo2(){
        Jedis jedis = jedis();
        jedis.mset("k1","v1","k2","v2");
        jedis.close();
    }
}
