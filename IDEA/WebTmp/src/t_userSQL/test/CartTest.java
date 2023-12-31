package t_userSQL.test;

import org.junit.Test;
import t_userSQL.pojo.Cart;
import t_userSQL.pojo.CartItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author 金鱼
 * @title: CartTest
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/119:12
 */
public class CartTest {
    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.addItem(new CartItem(2,"c++厉害",1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"c++厉害",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"c++厉害",1,new BigDecimal(100),new BigDecimal(100)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"c++厉害",1,new BigDecimal(100),new BigDecimal(100)));
        cart.clear();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.updateCount(1, 10);
        System.out.println(cart);
    }
}