package com.chen.spring5.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ����
 * @title: UserProxy
 * @projectName Spring5
 * @description: ��ǿ��
 * @date 2021/11/2516:41
 */
@Component
@Aspect
public class UserProxy {

    @Pointcut(value = "execution(* com.chen.spring5.AOP.User.add(..))")
    public void pointcut(){
    }
    //ǰ��֪ͨ
    @Before(value = "pointcut()")
    public void before(){
        System.out.println("Before.......pointcut....");
    }
    //����֪ͨ

    @After(value = "execution(* com.chen.spring5.AOP.User.add(..))")
    public void after(){
        System.out.println("after.......");
    }


    //����֪ͨ

    @Around(value = "execution(* com.chen.spring5.AOP.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("ִ��֮ǰ��������");
        proceedingJoinPoint.proceed();
        System.out.println("ִ��֮�󡣡�����");
    }
}
