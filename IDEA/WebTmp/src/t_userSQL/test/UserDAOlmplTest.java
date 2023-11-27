package t_userSQL.test;

import org.junit.Test;
import t_userSQL.dao.UserDAO;
import t_userSQL.dao.impl.UserDAOlmpl;
import t_userSQL.pojo.User;

/**
 * @author 金鱼
 * @title: UserDAOlmplTest
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/9/2516:47
 */
public class UserDAOlmplTest {
    UserDAO userDAO = new UserDAOlmpl();
    @Test
    public void queryUserByUsername() {
//        if (userDAO.queryUserByUsername("admin") == null){
//            System.out.println("用户名可用！");
//        }else {
//            System.out.println("用户名已存在！");
//        }
        System.out.println(userDAO.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUserAndPassword() {
//        if (userDAO.queryUserByUserAndPassword("admin","sddsdds") ==null){
//            System.out.println("用户名或密码错误！");
//        }else{
//            System.out.println("登录成功！");
//        }
        System.out.println(userDAO.queryUserByUserAndPassword("admin1","123456"));

    }

    @Test
    public void saveUser() {
        System.out.println(userDAO.saveUser(new User(null,"admin3","123456","chen@qq.com")));
    }
}