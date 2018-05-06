package com.usher.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * data：商品内容
 */
@Data
public class ProductVO implements Serializable{

    private static final long serialVersionUID = 6857927093872973204L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
