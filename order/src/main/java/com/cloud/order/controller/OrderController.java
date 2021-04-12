package com.cloud.order.controller;

import com.cloud.order.DataObject.OrderDetail;
import com.cloud.order.client.ProductClient;
import com.cloud.order.converter.OrderForm2OrderDto;
import com.cloud.order.dto.OrderDto;
import com.cloud.order.dto.OrderForm;
import com.cloud.order.dto.ResultVO;
import com.cloud.order.enums.ResultEnum;
import com.cloud.order.exception.OrderException;
import com.cloud.order.service.OrderService;
import com.cloud.order.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    static Logger logger = LoggerFactory.getLogger(OrderController.class);
    /**
     * 1参数校验
     * 2查询商品信息（调用商品服务）
     * 3计算总价
     * 4扣库存（调用商品服务）
     * 5订单入库
     *
     */
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;

    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        // oderFrom -> orderTDO
        OrderDto orderDto = OrderForm2OrderDto.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            logger.error("【创建订单】 购物车为空");
            throw new OrderException(ResultEnum.CAT_EMPTY);
        }
        List<OrderDetail> orderDetails = orderDto.getOrderDetailList();
        List<String>  productIds =  orderDto.getOrderDetailList().stream()
                .map(OrderDetail::getProductId).collect(Collectors.toList());
        productClient.listForOrder(productIds);
        OrderDto reuslt =  orderService.create(orderDto);
        return ResultVOUtil.success(reuslt);
    }

    @GetMapping("/list")
    public String getProductMsg(){
        String response = productClient.productList();
        return  response;
    }


}
