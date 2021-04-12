package com.cloud.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    /*商品名称*/
    @JsonProperty("name")
    private String productName;

    /*商品价格*/
    @JsonProperty("price")
    private BigDecimal productPrice;

    /*描述*/
    @JsonProperty("description")
    private String productDescription;

    /*小图*/
    @JsonProperty("icon")
    private String productIcon;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }
}
