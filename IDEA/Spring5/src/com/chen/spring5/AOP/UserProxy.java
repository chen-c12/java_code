package com.chen.spring5.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 金鱼
 * @title: UserProxy
 * @projectName Spring5
 * @description: 增强类
 * @date 2021/11/2516:41
 */
@Component
@Aspect
public class UserProxy {

    @Pointcut(value = "execution(* com.chen.spring5.AOP.User.add(..))")
    public void pointcut(){
    }
    //前置通知
    @Before(value = "pointcut()")
    public void before(){
        System.out.println("Before.......pointcut....");
    }
    //后置通知

    @After(value = "execution(* com.chen.spring5.AOP.User.add(..))")
    public void after(){
        System.out.println("after.......");
    }


    //环绕通知

    @Around(value = "execution(* com.chen.spring5.AOP.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("执行之前。。。。");
        proceedingJoinPoint.proceed();
        System.out.println("执行之后。。。。");
    }
}
