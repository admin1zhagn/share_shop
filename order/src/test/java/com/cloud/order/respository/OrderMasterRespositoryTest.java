package com.cloud.order.respository;

import com.cloud.order.DataObject.OrderMaster;
import com.cloud.order.OrderApplicationTests;
import com.cloud.order.enums.OrderStatusEnum;
import com.cloud.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMasterRespositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRespository respository;

    @Test
    public void testSava(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("zhangzhan");
        orderMaster.setBuyerAddress("厦门");
        orderMaster.setBuyerOpenid("12345611");
        orderMaster.setBuyerPhone("1234561");
        orderMaster.setPayStatus(PayStatusEnum.UNPAY.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setOrderAmount(new BigDecimal(123.11));
      OrderMaster reusult=  respository.save(orderMaster);
        Assert.assertTrue(reusult!=null);
    }
}