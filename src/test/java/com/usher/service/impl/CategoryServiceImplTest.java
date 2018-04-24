package com.usher.service.impl;

import com.usher.entities.ProductCategory;
import com.usher.service.impl.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * Service层测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class CategoryServiceImplTest {
    
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(2);
        Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("susi", 10);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}
