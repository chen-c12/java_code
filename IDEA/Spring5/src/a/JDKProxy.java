package a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author 金鱼
 * @title: JDKProxy
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2514:12
 */
public class JDKProxy {

    public static void main(String[] args) {
        //创建接口实现代理对象
        Class[] interfaces = {UserDao.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = dao.add(1, 2);
        String update = dao.update("11");
        System.out.println("result:"+add);
        System.out.println("result:"+update);
    }
}

//创建代码对象代码
class UserDaoProxy implements InvocationHandler{
    //把代理对象传递到代理类中
    //有参构造传递
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }
    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //方法之前
        System.out.println("方法之前执行"+method.getName()+"传递参数:"+ Arrays.toString(args));
        //被增强的方法执行
        Object res = method.invoke(obj, args);
        //方法之后
        System.out.println("方法之后执行"+obj+method.getName()+"传递参数:"+ Arrays.toString(args));

        return res;
    }
}