package com.cloud.product.service.impl;

import com.cloud.product.VO.CartDto;
import com.cloud.product.dataobject.ProductInfo;
import com.cloud.product.enums.ProductStatusEnum;
import com.cloud.product.enums.ResultEnum;
import com.cloud.product.exception.ProductException;
import com.cloud.product.repository.ProductInfoRepository;
import com.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 查询所有在架商品
     *
     * @return 商品列表
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 根据id查找商品
     *
     * @param productIds
     * @return 商品列表
     */
    @Override
    public List<ProductInfo> findByProductIdIn(List<String> productIds) {
        return productInfoRepository.findByProductIdIn(productIds);
    }

    /**
     * 扣库存
     *
     * @param cartDtos
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtos) {
        for (CartDto cart : cartDtos) {
            Optional<ProductInfo> productOptional = productInfoRepository.findById(cart.getProductId());
            //判断商品是否存在
            if(!productOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo= productOptional.get();
            Integer result = productInfo.getProductStock() - cart.getProductQuantity();
            //判断库存是否够
            if(result < 0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
