package com.chenddd.springbootredis;

import com.chenddd.springbootredis.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testUserRedis() throws JsonProcessingException {
        User user = new User("chenddd", 3);
        String valueAsString = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", valueAsString);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
