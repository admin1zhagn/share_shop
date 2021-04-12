package com.cloud.order.respository;

import com.cloud.order.DataObject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 订单服务
 */
@Service
public interface OrderMasterRespository extends JpaRepository<OrderMaster,String> {


}
