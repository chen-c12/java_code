package t_userSQL.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ����
 * @title: Order
 * @projectName WebTmp
 * @description: Order��bean
 * @date 2021/11/1515:20
 */
public class Order {
    private String orderId;
    private Date crateTime;
    private BigDecimal price;
    private Integer status = 0;
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, Date crateTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.crateTime = crateTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", crateTime=" + crateTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
