package com.usher.repository;

import com.usher.entities.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Usher
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456788");
        orderDetail.setOrderId("1111111");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("111111111");
        orderDetail.setProductName("回锅肉");
        orderDetail.setProductPrice(new BigDecimal(25));
        orderDetail.setProductQuantity(2);

        OrderDetail res = repository.save(orderDetail);
        Assert.assertNotNull(res);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("1111111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}