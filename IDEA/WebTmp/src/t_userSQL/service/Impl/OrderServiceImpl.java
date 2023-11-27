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
 * @author 金鱼
 * @title: OrderServiceImpl
 * @projectName WebTmp
 * @description: OrderService订单service程序
 * @date 2021/11/1516:02
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号（唯一性）
        String orderId = System.currentTimeMillis()+""+userId;
        //创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单
        orderDao.saveOrder(order);

        //遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem> entry:
        cart.getItems().entrySet()){
            //获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            //转换每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getPrice(),orderId);
            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            //更新销量
            book.setSales(book.getSales()+cartItem.getCount());
            //更新库存
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }

        cart.clear();

        return orderId;
    }
}
