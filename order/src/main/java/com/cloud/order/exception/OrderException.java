package com.cloud.order.exception;

import com.cloud.order.enums.ResultEnum;

public class OrderException extends RuntimeException{

    private Integer code;

    public OrderException(Integer code ,String message){
        super(message);
        this.code=code;
    }
    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
