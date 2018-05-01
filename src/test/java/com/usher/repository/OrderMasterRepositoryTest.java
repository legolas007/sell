package com.usher.repository;

import com.usher.entities.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: Usher
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "110110";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234568");
        orderMaster.setBuyerName("Usher");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("SDUST");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid(){
        PageRequest request = new PageRequest(0,3);
        Page<OrderMaster> res = repository.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,res.getTotalElements());
        System.out.println(res.getTotalElements());

    }
}