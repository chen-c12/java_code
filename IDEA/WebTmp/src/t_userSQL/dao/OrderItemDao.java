package t_userSQL.dao;

import t_userSQL.pojo.OrderItem;

/**
 * @author 金鱼
 * @title: OrderItemDao
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1515:27
 */
public interface OrderItemDao {

    //保存订单项
    public int saveOrderItem(OrderItem orderItem);

}
