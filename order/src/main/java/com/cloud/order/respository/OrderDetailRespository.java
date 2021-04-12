package com.cloud.order.respository;

import com.cloud.order.DataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 订单详情服务
 */
@Service
public interface OrderDetailRespository extends JpaRepository<OrderDetail,String> {


}
