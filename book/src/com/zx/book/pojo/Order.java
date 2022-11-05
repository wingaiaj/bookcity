package com.zx.book.pojo;

import java.util.Date;

/**
 * @ClassName Order
 * @Description TODO
 * @Author xpower
 * @Date 2022/11/5 15:55
 * @Version 1.0
 */
public class Order {

    private Integer id;
    private String orderNo;
    private Date orderDate;
    private Integer OrderUser;
    private Double orderMoney;
    private Integer OrderStatus;

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderUser() {
        return OrderUser;
    }

    public void setOrderUser(Integer orderUser) {
        OrderUser = orderUser;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        OrderStatus = orderStatus;
    }
}
