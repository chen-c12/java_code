package webs;

import t_userSQL.User;
import t_userSQL.UserService;
import t_userSQL.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 金鱼
 * @title: RegistServlet
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/9/2714:39
 */
public class RegistServlet extends HttpServlet {

    private UserService userService1 = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("abcde".equalsIgnoreCase(code)){
            if (userService1.existsUsername(username)){
                System.out.println("用户名"+username+"已存在！");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            }else {
                userService1.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);

            }
        }else {
            System.out.println("验证码{"+code+"}错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
