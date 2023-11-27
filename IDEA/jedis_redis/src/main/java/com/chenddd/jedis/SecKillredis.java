package com.chenddd.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author 金鱼
 * @title: SecKillredis
 * @projectName jedis_redis
 * @description: 秒杀模拟
 * @date 2022/3/2417:24
 */
public class SecKillredis {
    public static boolean doSecKillredis(String uid,String prodid){
        //1.uid和prodid非空判断
        if (uid == null || prodid == null){
            return false;
        }
        //连接redis
        Jedis jedis = new Jedis("192.168.184.150",6379);

        //3.拼接key
        //3.1库存key
        String kcKey = "sk:"+uid+":qt";
        //3.2秒杀成功用户id
        String userKey = "sk:"+prodid+"user";
        //4.获取库存，如果库存null，秒杀还没开始
        if (jedis.get(kcKey) == null){
            System.out.println("秒杀还没有开始！");
            jedis.close();
            return false;
        }
        //5.判断用户是否重复秒杀操作
        if (jedis.sismember(userKey, uid)){
            System.out.println("您已经秒杀成功");
            jedis.close();
            return false;
        }

        //6.判断商品数量，库存数量小于1，秒杀结束
        if (Integer.parseInt(jedis.get(kcKey))<1){
            System.out.println("商品已经被抢空啦！！！");
            jedis.close();
            return false;
        }
       //秒杀过程
        //库存-1
        jedis.decr(userKey);
        jedis.sadd(userKey, uid);
        System.out.println("秒杀成功了");
        jedis.close();
        return true;
    }
}
