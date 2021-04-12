package com.cloud.order.dto;

import com.cloud.order.DataObject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单dto
 */
public class OrderDto {
    private String orderId;
    /*买家名字*/
    private String buyerName;
    /*买家电话*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家openid*/
    private String buyerOpenid;
    /*订单总金额*/
    private BigDecimal OrderAmount;
    /*订单状态*/
    private Integer orderStatus;
    /*付款状态*/
    private Integer PayStatus;
    /*订单详情*/
    List<OrderDetail> orderDetailList ;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    public BigDecimal getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        OrderAmount = orderAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return PayStatus;
    }

    public void setPayStatus(Integer payStatus) {
        PayStatus = payStatus;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
