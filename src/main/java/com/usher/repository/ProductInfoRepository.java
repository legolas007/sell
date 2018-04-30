package com.usher.repository;

import com.usher.entities.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public interface ProductInfoRepository extends JpaRepository <ProductInfo,String>{
    //根据状态查询商品信息
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
