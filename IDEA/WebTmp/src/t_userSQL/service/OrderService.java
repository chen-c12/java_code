package t_userSQL.service;

import t_userSQL.pojo.Cart;

/**
 * @author Н№гу
 * @title: OrderService
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1516:01
 */
public interface OrderService {

    public String createOrder(Cart cart,Integer userId);

}
