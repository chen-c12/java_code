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
 * @author Н№гу
 * @title: LoginServlet
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/10/98:50
 */
public class LoginServlet extends HttpServlet {
    private UserService userServices =  new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userServices.login(new User(null, username, password, null));
        if (loginUser == null){
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }
    }
}
