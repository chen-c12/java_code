package a;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @author 金鱼
 * @title: TestAOP
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2423:34
 */
interface Human{
    void info();
    void fly();
}
//被代理类
class SuperMan implements Human{
    @Override
    public void info() {
        System.out.println("1111");
    }
    @Override
    public void fly() {
        System.out.println("22222222");
    }
}


class MyInvocation implements InvocationHandler {
    Object obj;
    public void setObject(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
     Object returnVal = method.invoke(obj,args);
     return returnVal;
    }
}
class MyProxy{
    public static Object getProxyInstance(Object obj){
        MyInvocation handle = new MyInvocation();
        handle.setObject(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handle);
    }
}
public class TestAOP {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();//创建一个被代理对象
        Object obj = MyProxy.getProxyInstance(superMan);//返回一个代理类对象
        Human hu = (Human) obj;
        hu.info();//通过代理类的对象调用重写的抽象方法
        System.out.println();
        hu.fly();

    }
}
