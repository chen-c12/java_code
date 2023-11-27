package com.chen.spring5.AOP;

import org.springframework.stereotype.Component;

/**
 * @author 金鱼
 * @title: User
 * @projectName Spring5
 * @description: 被增强类
 * @date 2021/11/2516:40
 */
@Component
public class User {
    public void add(){
        System.out.println("add...........");
    }
}
