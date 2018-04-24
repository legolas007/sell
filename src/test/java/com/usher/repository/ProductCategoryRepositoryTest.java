package com.usher.repository;

import com.usher.entities.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;
    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    @Transactional//事务回滚，不插入mysql
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("favorite2",3);
        ProductCategory res = repository.save(productCategory);
        Assert.assertNotNull(res);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> res = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,res.size());
    }
    @Test
    public void updateTest(){
        ProductCategory productCategory = new ProductCategory("love",2);
        ProductCategory res = repository.save(productCategory);
        Assert.assertEquals(productCategory,res);


    }
}
