package webs;

import com.google.gson.Gson;
import t_userSQL.pojo.User;
import t_userSQL.service.UserService;
import t_userSQL.service.Impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author ����
 * @title: UserServlet
 * @projectName WebTmp
 * @description: �����û���¼��ע��
 * @date 2021/10/3015:12
 */
public class UserServlet extends BaseServlet {
    private UserService userServices = new UserServiceImpl();

    /**
     * ��¼
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userServices.login(new User(null, username, password, null));
        if (loginUser == null) {
            //�Ѵ�����Ϣ���ͻ��Եı�����Ϣ�����浽request����
            req.setAttribute("msg", "�û�����������󣡣�");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //�����û���¼�����Ϣ��Session����
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * ע��
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ��ȡ Session �е���֤��
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // ɾ�� Session �е���֤��
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        /*User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());*/

        if (token != null && token.equalsIgnoreCase(code)) {
            if (userServices.existsUsername(username)) {
                req.setAttribute("msg", "�û����Ѵ��ڣ���");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userServices.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);

            }
        } else {
            //�ѻ�����Ϣ���浽request����
            req.setAttribute("msg", "��֤����󣡣�");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    //�û�ע��
    protected void loginout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session��������
        req.getSession().invalidate();
        //�ض�����ҳ
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * ajax��֤�û���
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //��ȡ����Ĳ���
        String username = req.getParameter("username");
        //����userService.existsUsername();
        boolean existsUsername = userServices.existsUsername(username);
        //�ѷ��صĽ����װΪmap����
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername", existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);
    }
}
