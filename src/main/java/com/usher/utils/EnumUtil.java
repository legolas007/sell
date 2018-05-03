package com.usher.utils;

import com.usher.enums.CodeEnum;

/**
 * @Author: Usher
 * @Description:
 * 返回状态
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
