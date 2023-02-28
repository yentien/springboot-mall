package com.arthurtien.springbootmall.service.impl;

import com.arthurtien.springbootmall.dao.ProductDao;
import com.arthurtien.springbootmall.model.Product;
import com.arthurtien.springbootmall.service.ProductSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductSercice {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
