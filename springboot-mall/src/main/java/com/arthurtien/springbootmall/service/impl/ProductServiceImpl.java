package com.arthurtien.springbootmall.service.impl;

import com.arthurtien.springbootmall.dao.ProductDao;
import com.arthurtien.springbootmall.dto.ProductRequest;
import com.arthurtien.springbootmall.model.Product;
import com.arthurtien.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// 實作 ProductService 接口
// 目的: 降低整體程式對 ProductService class 的依賴

// 創建 bean
@Component
public class ProductServiceImpl implements ProductService {

    // 注入 Bean (productDao 接口)
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId,productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
