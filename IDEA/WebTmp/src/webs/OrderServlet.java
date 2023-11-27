package webs;

import t_userSQL.pojo.Cart;
import t_userSQL.pojo.User;
import t_userSQL.service.Impl.OrderServiceImpl;
import t_userSQL.service.OrderService;
import utils.Jdbcutils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ����
 * @title: OrderServlet
 * @projectName WebTmp
 * @description: ����servlet����
 * @date 2021/11/1516:41
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    //���涩��
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //�Ȼ�ȡcart���ﳵ����
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //��ȡuserid
        User loginUser = (User) req.getSession().getAttribute("user");

        if(loginUser == null){
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            return;
        }

        Integer id = loginUser.getId();
        String orderId = orderService.createOrder(cart, id);

        req.getSession().setAttribute("orderId", orderId);

        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");

    }
}
