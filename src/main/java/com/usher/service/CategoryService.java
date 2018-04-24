package com.usher.service;

import com.usher.entities.ProductCategory;

import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * 分类service层接口
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
