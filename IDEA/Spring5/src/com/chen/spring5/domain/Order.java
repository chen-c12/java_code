package com.chen.spring5.domain;

/**
 * @author Н№гу
 * @title: Order
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2116:34
 */
public class Order {
    private String name;
    private String order;

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(String order) {
        this.order = order;
    }
    public void showOrder(){
        System.out.println(name+"::"+order);
    }
}
