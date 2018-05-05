package com.usher.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usher.enums.ProductStatusEnum;
import com.usher.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Usher
 * @Description:
 * 商品信息
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    //状态，0正常，1下架
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    //类目编号
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }

}
