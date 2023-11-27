package t_userSQL.test;

import org.junit.Test;
import t_userSQL.pojo.Cart;
import t_userSQL.pojo.CartItem;
import t_userSQL.service.Impl.OrderServiceImpl;
import t_userSQL.service.OrderService;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Н№гу
 * @title: OrderServiceImplTest
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1516:20
 */
public class OrderServiceImplTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"weweww",1,new BigDecimal(10),new BigDecimal(20)));
        cart.addItem(new CartItem(2,"wefdf",1,new BigDecimal(10),new BigDecimal(20)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println(orderService.createOrder(cart, 1));
    }
}