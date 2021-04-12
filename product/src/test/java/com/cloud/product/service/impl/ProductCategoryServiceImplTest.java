package com.cloud.product.service.impl;

import com.cloud.product.dataobject.ProductCategory;
import com.cloud.product.repository.ProductCategoryRespository;
import com.cloud.product.repository.ProductCategoryRespositoryTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductCategoryServiceImplTest extends ProductCategoryRespositoryTest {

    @Autowired
    private ProductCategoryRespository respository;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list = respository.findByCategoryTypeIn(Arrays.asList(11, 12));
        Assert.assertTrue(list.size() > 0);
    }
}