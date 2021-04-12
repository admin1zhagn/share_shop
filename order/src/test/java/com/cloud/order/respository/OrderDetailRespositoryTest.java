package com.cloud.order.respository;

import com.cloud.order.DataObject.OrderDetail;
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
public class OrderDetailRespositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRespository respository;

    @Test
    public void testSava(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("123456");
        orderDetail.setDetailId("123");
        orderDetail.setProductIcon("厦门");
        orderDetail.setProductId("12345611");
        orderDetail.setProductName("1234561");
        orderDetail.setProductPrice(new BigDecimal(123));
        orderDetail.setProductQuantity(2);
      OrderDetail reusult=  respository.save(orderDetail);
        Assert.assertTrue(reusult != null);
    }
}