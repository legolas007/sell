package com.usher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Usher
 * @Description:
 * 购物车
 */
@Data
//@AllArgsConstructor
public class CartDTO {
    /*商品ID*/
    private String productId;

    /*数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
