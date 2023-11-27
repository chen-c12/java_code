package com.chenddd.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author ����
 * @title: SecKillredis
 * @projectName jedis_redis
 * @description: ��ɱģ��
 * @date 2022/3/2417:24
 */
public class SecKillredis {
    public static boolean doSecKillredis(String uid,String prodid){
        //1.uid��prodid�ǿ��ж�
        if (uid == null || prodid == null){
            return false;
        }
        //����redis
        Jedis jedis = new Jedis("192.168.184.150",6379);

        //3.ƴ��key
        //3.1���key
        String kcKey = "sk:"+uid+":qt";
        //3.2��ɱ�ɹ��û�id
        String userKey = "sk:"+prodid+"user";
        //4.��ȡ��棬������null����ɱ��û��ʼ
        if (jedis.get(kcKey) == null){
            System.out.println("��ɱ��û�п�ʼ��");
            jedis.close();
            return false;
        }
        //5.�ж��û��Ƿ��ظ���ɱ����
        if (jedis.sismember(userKey, uid)){
            System.out.println("���Ѿ���ɱ�ɹ�");
            jedis.close();
            return false;
        }

        //6.�ж���Ʒ�������������С��1����ɱ����
        if (Integer.parseInt(jedis.get(kcKey))<1){
            System.out.println("��Ʒ�Ѿ���������������");
            jedis.close();
            return false;
        }
       //��ɱ����
        //���-1
        jedis.decr(userKey);
        jedis.sadd(userKey, uid);
        System.out.println("��ɱ�ɹ���");
        jedis.close();
        return true;
    }
}
