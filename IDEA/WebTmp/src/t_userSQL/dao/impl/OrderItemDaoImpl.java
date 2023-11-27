package t_userSQL.dao.impl;

import t_userSQL.dao.OrderItemDao;
import t_userSQL.pojo.OrderItem;

/**
 * @author Н№гу
 * @title: OrderItemDaoImpl
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1515:34
 */
public class OrderItemDaoImpl extends BaseDAO implements OrderItemDao {
    private BaseDAO baseDAO = new BookDaoImpl();
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(id,name,count,price,totalPrice,orderId) values(?,?,?,?,?,?)";
        return baseDAO.update(sql, orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
