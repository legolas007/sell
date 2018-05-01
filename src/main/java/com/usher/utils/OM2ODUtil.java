package com.usher.utils;

import com.usher.dto.OrderDTO;
import com.usher.entities.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Usher
 * @Description:
 * OrderMaster to OrderDTO
 *
 */
public class OM2ODUtil {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream()
                .map(OM2ODUtil::convert)
                .collect(Collectors.toList());
    }
}
