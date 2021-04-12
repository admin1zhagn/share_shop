package com.cloud.order.client;

import com.cloud.order.DataObject.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/product/list")
    String productList();

    @PostMapping("/product/getProductList")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIds);
}
