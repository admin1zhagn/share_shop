package com.cloud.product.service.impl;

import com.cloud.product.VO.CartDto;
import com.cloud.product.dataobject.ProductInfo;
import com.cloud.product.repository.ProductInfoRepositoryTest;
import com.cloud.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceImplTest extends ProductInfoRepositoryTest {

    @Autowired
    private ProductService productServer;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productServer.findUpAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> list = productServer.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));
        Assert.assertTrue(list.size()>0);
    }
    @Test
    public void decreaseStock(){
        List<CartDto> cartDtos = new ArrayList<>();

        CartDto cartDto = new CartDto("157875227953464068",2);
        CartDto cartDto1 = new CartDto("164103465734242707",3);
        cartDtos.add(cartDto);
        cartDtos.add(cartDto1);
        productServer.decreaseStock(cartDtos);

    }
}