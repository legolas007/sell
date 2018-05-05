package com.usher.form;

import lombok.Data;

/**
 * @Author: Usher
 * @Description:
 */
@Data
public class CategoryForm {
    private Integer categoryId;

    //类目名字
    private String categoryName;

    //类目编号
    private Integer categoryType;
}
