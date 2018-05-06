package com.usher.entities.dao;

import com.usher.entities.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
//@Repository不加这个注解的dao，应该是用了xml进行注入，不然会错
@Repository
public class ProductCategoryDao {
    @Autowired
    private ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }
}
