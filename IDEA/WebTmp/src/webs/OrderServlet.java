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
 * @author 金鱼
 * @title: OrderServlet
 * @projectName WebTmp
 * @description: 订单servlet程序
 * @date 2021/11/1516:41
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    //保存订单
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取userid
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
