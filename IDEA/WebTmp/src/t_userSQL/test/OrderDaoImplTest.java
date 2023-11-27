package t_userSQL.test;

import org.junit.Test;
import t_userSQL.dao.OrderDao;
import t_userSQL.dao.OrderItemDao;
import t_userSQL.dao.impl.OrderDaoImpl;
import t_userSQL.dao.impl.OrderItemDaoImpl;
import t_userSQL.pojo.Order;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Н№гу
 * @title: OrderDaoImplTest
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1515:40
 */
public class OrderDaoImplTest {
    private OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1233232",new Date(),new BigDecimal(100),0,111));
    }
}