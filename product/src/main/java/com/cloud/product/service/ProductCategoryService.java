package com.cloud.product.service;

import com.cloud.product.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 获取类目type列表
     * @param list
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> list) ;
}
