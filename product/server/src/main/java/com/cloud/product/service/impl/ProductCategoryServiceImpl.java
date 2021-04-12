package com.cloud.product.service.impl;

import com.cloud.product.dataobject.ProductCategory;
import com.cloud.product.repository.ProductCategoryRespository;
import com.cloud.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRespository respository;
    /**
     * 获取类目type列表
     *
     * @param list
     * @return type列表
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> list) {
        return respository.findByCategoryTypeIn(list);
    }
}
