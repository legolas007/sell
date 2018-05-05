package com.usher.repository;

import com.usher.entities.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Usher
 * @Description:
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
