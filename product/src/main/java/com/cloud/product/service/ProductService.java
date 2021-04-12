package com.cloud.product.service;

import com.cloud.product.VO.CartDto;
import com.cloud.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有在架商品
     * @return 商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有在架商品
     * @return 商品列表
     */
    List<ProductInfo> findByProductIdIn(List<String> productIds);


    /**
     * 扣库存
     * @param cartDtos
     */
    void decreaseStock(List<CartDto> cartDtos);

}
