package com.cloud.product.controller;

import com.cloud.product.VO.ProductInfoVO;
import com.cloud.product.VO.ProductVO;
import com.cloud.product.VO.ResultVO;
import com.cloud.product.dataobject.ProductCategory;
import com.cloud.product.dataobject.ProductInfo;
import com.cloud.product.service.ProductCategoryService;
import com.cloud.product.service.ProductService;
import com.cloud.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    /*1.查询所有在架的商品
     * 2.获取类目type列表
     * 3。查询类目
     * 4.构造数据*/
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO productAllList() {
        List<ProductInfo> productList = productService.findUpAll();
        List<Integer> categoryTypeIdList = productList.stream()
                .map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> productCategories = productCategoryService.findByCategoryTypeIn(categoryTypeIdList);
        Map<ProductInfo, String> productMap;
        List<ProductVO> productVOS = new ArrayList<>();
        for (ProductCategory productcategory : productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productcategory.getCategoryName());
            productVO.setCategoryType(productcategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productList) {
                if (productcategory.getCategoryId().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }
            productVO.setProductInfoVOList(productInfoVOList);


            productVOS.add(productVO);
        }

        return ResultVOUtil.success(productVOS);
    }

    @PostMapping("/getProductList")
    public List<ProductInfo> listForOrder(@RequestBody  List<String> productids) {
        return productService.findByProductIdIn(productids);
    }

}
