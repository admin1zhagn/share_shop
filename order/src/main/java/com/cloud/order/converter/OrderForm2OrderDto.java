package com.cloud.order.converter;

import com.cloud.order.DataObject.OrderDetail;
import com.cloud.order.controller.OrderController;
import com.cloud.order.dto.OrderDto;
import com.cloud.order.dto.OrderForm;
import com.cloud.order.enums.ResultEnum;
import com.cloud.order.exception.OrderException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class OrderForm2OrderDto {
    static Logger logger = LoggerFactory.getLogger(OrderForm2OrderDto.class);

    public static OrderDto convert(OrderForm orderForm){
        OrderDto orderDto = new OrderDto();
        Gson gson = new Gson();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetails= new ArrayList<>();

        try {
            orderDetails =  gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){
            }.getType());
        }catch (Exception e) {
            logger.error("【json】转换错误 string={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailList(orderDetails);

        return orderDto;

    }
}
