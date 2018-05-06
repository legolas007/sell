package com.usher.entities.mapper;

import com.usher.entities.ProductCategory;
import com.usher.entities.mapper.ProductCategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

/**
 * @Author: Usher
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;



    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", "夜宵了解一下");
        map.put("category_type", 13);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("秋意浓");
        productCategory.setCategoryType(102);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }


    @Test
    public void findByCategoryType() {
        ProductCategory result = mapper.findByCategoryType(102);
        log.info(result.getCategoryName());
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> result = mapper.findByCategoryName("秋意浓");
        for(ProductCategory productCategory:result){
            log.info(productCategory.getCategoryName()+"/"+productCategory.getCategoryId());
        }
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void updateByCategoryType() {
        int result = mapper.updateByCategoryType("凛冬已至", 102);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("秋意浓");
        productCategory.setCategoryType(102);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1, result);
    }


    @Test
    public void deleteByCategoryType() {
        int result = mapper.deleteByCategoryType(103);
        Assert.assertEquals(1, result);
    }


    //xml
    @Test
    public void selectByCategoryType() {
        List<ProductCategory> result = mapper.selectByCategoryType(101);
        for(ProductCategory productCategory:result){
            log.info(productCategory.getCategoryName()+"/"+productCategory.getCategoryId());
        }
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void selectByCategoryName() {
        ProductCategory result = mapper.selectByCategoryName("秋意浓");
        log.info(result.getCategoryName());
        Assert.assertNotNull(result);
    }
}