package com.zx.book.pojo;

/**
 * @ClassName OrderItem
 * @Description TODO
 * @Author xpower
 * @Date 2022/11/5 15:56
 * @Version 1.0
 */
public class OrderItem {
    private Integer id;
    private Integer book;
    private Integer buyCount;
    private Integer orderBean;

    public OrderItem() {
    }

    public OrderItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(Integer orderBean) {
        this.orderBean = orderBean;
    }
}
