package com.usher.service;

import com.usher.dto.OrderDTO;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: Usher
 * @Description: 订单
 */
//对象与对象之间涉及转化
public interface OrderService {
    /* 创建订单 */
    OrderDTO create(OrderDTO orderDTO);
    /* 查询单个订单 */
    OrderDTO findOne(String orderId);
    /*查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid , Pageable pageable);
    Page<OrderDTO> findList( Pageable pageable);
    /*取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);
    /*完成订单*/
    OrderDTO finish(OrderDTO orderDTO);
    /*支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

}
