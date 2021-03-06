package com.cloud.product.exception;
import com.cloud.product.enums.ResultEnum;

/**
 * 商品异常
 */
public class ProductException extends RuntimeException {
    private Integer code;


    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;

    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = code;
    }
}
