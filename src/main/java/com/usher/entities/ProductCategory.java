package com.usher.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: Usher
 * @Description:
 * 分类
 */
@Entity//告诉JPA这是一个实体类（和数据表映射的类）
@DynamicUpdate
@Data//lombok自动装配
//使用JPA注解配置映射关系，根据数据库表编写实体类
public class ProductCategory {

    /**
     * 分类ID
     */
    @Id//这是一个主键
    @GeneratedValue//自增主键
    private Integer categoryId;
    /**
     * 分类名字
     */
    private String categoryName;
    /**
     * 分类编号
     */
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
