package com.usher.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Usher
 * @Description:
 * 返回给前端的数据
 * http请求返回的最外层对象
 */
@Data
public class ResultVO <T> implements Serializable{

    private static final long serialVersionUID = -1361990424274277560L;
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
