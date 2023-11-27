package t_userSQL.service.Impl;

import t_userSQL.dao.BookDao;
import t_userSQL.dao.OrderDao;
import t_userSQL.dao.OrderItemDao;
import t_userSQL.dao.impl.BookDaoImpl;
import t_userSQL.dao.impl.OrderDaoImpl;
import t_userSQL.dao.impl.OrderItemDaoImpl;
import t_userSQL.pojo.*;
import t_userSQL.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author ����
 * @title: OrderServiceImpl
 * @projectName WebTmp
 * @description: OrderService����service����
 * @date 2021/11/1516:02
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //�����ţ�Ψһ�ԣ�
        String orderId = System.currentTimeMillis()+""+userId;
        //����һ����������
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //���涩��
        orderDao.saveOrder(order);

        //�������ﳵ��ÿһ����Ʒ��ת����Ϊ������浽���ݿ�
        for (Map.Entry<Integer, CartItem> entry:
        cart.getItems().entrySet()){
            //��ȡÿһ�����ﳵ�е���Ʒ��
            CartItem cartItem = entry.getValue();
            //ת��ÿһ��������
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getPrice(),orderId);
            //���涩������ݿ�
            orderItemDao.saveOrderItem(orderItem);

            //���¿�������
            Book book = bookDao.queryBookById(cartItem.getId());
            //��������
            book.setSales(book.getSales()+cartItem.getCount());
            //���¿��
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }

        cart.clear();

        return orderId;
    }
}
