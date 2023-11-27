package com.chenddd.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author ����
 * @title: PhoneCode
 * @projectName jedis_redis
 * @description: ��ģ����֤����֤
 * @date 2022/3/2320:37
 */
public class PhoneCode {
    public static void main(String[] args) {
        //ģ����֤�뷢��
        //verifyCode("18665530215");
        getRedisCode("18665530215", "703325");
    }

    //1.����6λ���ֵ���֤��
    public static String getCode(){
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }

    //2.��֤�����redis��
    // ����120����ڣ�
    // ÿ��ֻ�ܷ�����
    public static  void verifyCode(String phone){
        Jedis jedis = redisConnection();

        //ƴ��key
        //�ֻ����ʹ���key
        String countKey = "VerifyCode"+phone+":count";
        //��֤��key
        String codeKey = "VerifyCode"+phone+":code";
        //ÿ��ֻ�ܷ�����
        String count = jedis.get(countKey);
        if (count==null){
            //û�з��ʹ�������һ�η���
            //���÷��ʹ���Ϊ1
            jedis.setex(countKey, 24*60*60, "1");
        }else if (Integer.parseInt(count)<=2){
            //���ʹ���+1
            jedis.incr(countKey);
        }else if (Integer.parseInt(count)>2){
            //�������Σ������ٷ���
            System.out.println("����ķ��ʹ����Ѿ��������ޣ�����");
            jedis.close();
            return;
        }

        //���͵���֤��Ҫ����redis��
        String vcode = getCode();
        jedis.setex(codeKey,120,vcode);
        jedis.close();
    }

    //3.��֤��У��
    public static void getRedisCode(String phone,String code){
            //��redis��ȡ��֤��
        Jedis jedis = redisConnection();
        //��֤��key
        String codeKey = "VerifyCode"+phone+":code";
        String redisCode = jedis.get(codeKey);
        if (redisCode.equals(code)){
            System.out.println("�ɹ�");
        }else {
            System.out.println("ʧ��");
        }
        jedis.close();
    }

    //redis����
    private static Jedis redisConnection(){
        //����redis
        Jedis jedis = new Jedis("192.168.184.150",6379);
        return jedis;
    }

}
