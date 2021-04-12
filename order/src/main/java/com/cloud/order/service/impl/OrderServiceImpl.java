package com.cloud.order.service.impl;

import com.cloud.order.DataObject.OrderMaster;
import com.cloud.order.dto.OrderDto;
import com.cloud.order.enums.OrderStatusEnum;
import com.cloud.order.enums.PayStatusEnum;
import com.cloud.order.respository.OrderDetailRespository;
import com.cloud.order.respository.OrderMasterRespository;
import com.cloud.order.service.OrderService;
import com.cloud.order.utils.RandomUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRespository respository;

    @Autowired
    private OrderDetailRespository orderDetailRespository;

    @Override
    public OrderDto create(OrderDto orderDto) {

        //TODO 2查询商品信息（调用商品服务） 3计算总价 4扣库存（调用商品服务）
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.UNPAY.getCode());
        orderMaster.setOrderId(RandomUtil.getRandomByCharAndNum(6));
        orderDto.setOrderId(orderMaster.getOrderId());
        respository.save(orderMaster);
        return orderDto;
    }
}
