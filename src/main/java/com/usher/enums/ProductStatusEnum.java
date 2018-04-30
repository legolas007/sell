package com.usher.enums;

import lombok.Getter;
import org.aopalliance.reflect.Code;

/**
 * @Author: Usher
 * @Description:
 * 商品状态
 */
@Getter
public enum  ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架"),
    ;

    private Integer code;
    private String message;
    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
