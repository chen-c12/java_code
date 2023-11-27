package com.ddd.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.Properties;

/**
 * @author 金鱼
 * @title: mybatisPlugin
 * @projectName commybatis
 * @description: TODO
 * @date 2022/2/814:47
 */

@Intercepts(
        {
                @Signature(type = StatementHandler.class,method = "parameterize",args = java.sql.Statement.class)
        }
)
public class mybatisPlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Mybatis...:Plugin"+invocation.getMethod());
        System.out.println("Mybatis...:Plugin"+invocation.getTarget());
        System.out.println("Mybatis...:Plugin"+invocation.getArgs());
        Object target = invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句的参数是："+value);
        metaObject.setValue("parameterHandler.parameterObject",1);
        Object proceed = invocation.proceed();
        return proceed;
    }

    public Object plugin(Object target) {
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息："+properties);
    }
}
