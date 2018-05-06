package com.usher.handler;

import com.usher.VO.ResultVO;
import com.usher.config.ProjectUrlConfig;
import com.usher.exception.SellException;
import com.usher.exception.SellerAuthorizeException;
import com.usher.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Usher
 * @Description:
 * 全局AOP登录验证异常处理
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 全局异常捕捉处理
     * 拦截登录异常
     * 重定向至登录页面 - 微信扫码登录
     * @return
     */
    //http://wpsell.natapp1.cc/sell/wechat/qrAuthorize?returnUrl=http://wpsell.natapp1.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())//微信开放平台登录授权地址
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())//服务器访问的地址
                .concat("/sell/seller/login"));
    }

    /**
     * 异常统一处理，返回json数据格式一致
     * @param e
     * @return
     */
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

/*
* //异常处理状态码返回
    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN) //返回状态码的修改
    @ResponseBody
    public ResultVO handlerResponseBankException(ResponseBankException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    */
}
