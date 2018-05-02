package com.usher.service;

import com.usher.dto.OrderDTO;

/**
 * @Author: Usher
 * @Description:
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
