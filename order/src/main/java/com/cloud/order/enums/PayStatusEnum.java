package com.cloud.order.enums;

public enum PayStatusEnum {
    UNPAY(0,"未付款"),
    PAY(1,"已付款"),
    CANCEL(2,"取消"),
    ;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
