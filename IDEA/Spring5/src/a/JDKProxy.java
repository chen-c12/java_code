package a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author ����
 * @title: JDKProxy
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2514:12
 */
public class JDKProxy {

    public static void main(String[] args) {
        //�����ӿ�ʵ�ִ������
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

//��������������
class UserDaoProxy implements InvocationHandler{
    //�Ѵ�����󴫵ݵ���������
    //�вι��촫��
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }
    //��ǿ���߼�
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //����֮ǰ
        System.out.println("����֮ǰִ��"+method.getName()+"���ݲ���:"+ Arrays.toString(args));
        //����ǿ�ķ���ִ��
        Object res = method.invoke(obj, args);
        //����֮��
        System.out.println("����֮��ִ��"+obj+method.getName()+"���ݲ���:"+ Arrays.toString(args));

        return res;
    }
}