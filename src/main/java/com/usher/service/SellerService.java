package com.usher.service;

import com.usher.entities.SellerInfo;

/**
 * @Author: Usher
 * @Description:
 * 卖家端管理
 */
public interface SellerService {

    /**
     * 通过openid查询买家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
