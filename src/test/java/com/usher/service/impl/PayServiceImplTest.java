package com.usher.service.impl;

import com.usher.dto.OrderDTO;
import com.usher.service.OrderService;
import com.usher.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Usher
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;


    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1525170517349514044");
        payService.create(orderDTO);
    }



    @Test
    public void refund() {
    }
}