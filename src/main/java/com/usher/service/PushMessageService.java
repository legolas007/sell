package com.usher.service;

import com.usher.dto.OrderDTO;

/**
 * @Author: Usher
 * @Description:
 * 推送消息
 */
public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
