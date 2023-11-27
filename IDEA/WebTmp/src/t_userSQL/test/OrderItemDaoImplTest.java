package t_userSQL.test;

import org.junit.Test;
import t_userSQL.dao.OrderItemDao;
import t_userSQL.dao.impl.OrderItemDaoImpl;
import t_userSQL.pojo.OrderItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Н№гу
 * @title: OrderItemDaoImplTest
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1515:51
 */
public class OrderItemDaoImplTest {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(1,"chen",2,new BigDecimal(20),new BigDecimal(40),"12332322"));
    }
}