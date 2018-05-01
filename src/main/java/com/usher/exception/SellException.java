package com.usher.exception;

import com.usher.enums.ResultEnum;

/**
 * @Author: Usher
 * @Description:
 */
//继承自RuntimeException，spring事务回滚，Exception没有
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
