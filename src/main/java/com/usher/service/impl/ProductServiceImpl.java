package com.usher.service.impl;

import com.usher.dto.CartDTO;
import com.usher.entities.ProductCategory;
import com.usher.entities.ProductInfo;
import com.usher.enums.ProductStatusEnum;
import com.usher.enums.ResultEnum;
import com.usher.exception.SellException;
import com.usher.repository.ProductInfoRepository;
import com.usher.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            Integer res = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(res);
            repository.save(productInfo);
        }

    }

    @Override
    @Transactional//事务管理
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            Integer res = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (res < 0)
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);

            productInfo.setProductStock(res);
            repository.save(productInfo);
        }
    }

    /**
     * 上架
     * @param productId
     * @return
     */
    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
        if (productInfo == null)
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP)
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);

        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        return repository.save(productInfo);
    }

    /**
     * 下架
     * @param productId
     * @return
     */
    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
        if (productInfo == null)
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN)
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);

        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        return repository.save(productInfo);
    }
}
