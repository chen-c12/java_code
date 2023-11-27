package t_userSQL.dao.impl;

import t_userSQL.dao.OrderDao;
import t_userSQL.pojo.Order;

/**
 * @author Н№гу
 * @title: OrderDaoImpl
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1515:29
 */
public class OrderDaoImpl extends BaseDAO implements OrderDao {
    private BaseDAO baseDAO = new BookDaoImpl();
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(),order.getCrateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
