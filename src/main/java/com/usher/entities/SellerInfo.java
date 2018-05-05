package com.usher.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: Usher
 * @Description:
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String Id;

    private String username;

    private String password;

    private String openid;
}
