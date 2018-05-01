package com.usher.dto;

import lombok.Data;

/**
 * @Author: Usher
 * @Description:
 * 购物车
 */
@Data
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
