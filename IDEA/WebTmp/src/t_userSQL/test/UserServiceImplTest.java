package t_userSQL.test;





import org.junit.Test;
import t_userSQL.service.UserService;
import t_userSQL.service.Impl.UserServiceImpl;
import t_userSQL.pojo.User;

/**
 * @author 金鱼
 * @title: UserServiceImplTest
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/9/2710:44
 */
public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registerUser(new User(null,"bbj1681111","66666","129021@.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin","admin",null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admin")){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}