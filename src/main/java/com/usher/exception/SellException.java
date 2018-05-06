package com.usher.exception;

import com.usher.enums.ResultEnum;
import lombok.Getter;

/**
 * @Author: Usher
 * @Description:
 */
@Getter
//继承自RuntimeException，spring事务回滚，Exception没有
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
