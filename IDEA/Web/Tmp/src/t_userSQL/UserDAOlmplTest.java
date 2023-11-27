package t_userSQL;

import org.junit.Test;

import static org.junit.Assert.*;

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
        if (userDAO.queryUserByUsername("admin") == null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUserAndPassword() {
        if (userDAO.queryUserByUserAndPassword("admin","sddsdds") ==null){
            System.out.println("用户名或密码错误！");
        }else{
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDAO.saveUser(new User(null,"admin3","123456","chen@qq.com")));
    }
}