package com.chenddd.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author 金鱼
 * @title: PhoneCode
 * @projectName jedis_redis
 * @description: 简单模拟验证码验证
 * @date 2022/3/2320:37
 */
public class PhoneCode {
    public static void main(String[] args) {
        //模拟验证码发送
        //verifyCode("18665530215");
        getRedisCode("18665530215", "703325");
    }

    //1.生成6位数字的验证码
    public static String getCode(){
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }

    //2.验证码放在redis，
    // 设置120秒过期，
    // 每天只能发三次
    public static  void verifyCode(String phone){
        Jedis jedis = redisConnection();

        //拼接key
        //手机发送次数key
        String countKey = "VerifyCode"+phone+":count";
        //验证码key
        String codeKey = "VerifyCode"+phone+":code";
        //每天只能发三次
        String count = jedis.get(countKey);
        if (count==null){
            //没有发送次数，第一次发送
            //设置发送次数为1
            jedis.setex(countKey, 24*60*60, "1");
        }else if (Integer.parseInt(count)<=2){
            //发送次数+1
            jedis.incr(countKey);
        }else if (Integer.parseInt(count)>2){
            //发送三次，不能再发送
            System.out.println("今天的发送次数已经到达上限！！！");
            jedis.close();
            return;
        }

        //发送的验证码要放在redis中
        String vcode = getCode();
        jedis.setex(codeKey,120,vcode);
        jedis.close();
    }

    //3.验证码校验
    public static void getRedisCode(String phone,String code){
            //从redis获取验证码
        Jedis jedis = redisConnection();
        //验证码key
        String codeKey = "VerifyCode"+phone+":code";
        String redisCode = jedis.get(codeKey);
        if (redisCode.equals(code)){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
        jedis.close();
    }

    //redis连接
    private static Jedis redisConnection(){
        //连接redis
        Jedis jedis = new Jedis("192.168.184.150",6379);
        return jedis;
    }

}
