package com.arthurtien.springbootmall.service;

import com.arthurtien.springbootmall.dto.ProductRequest;
import com.arthurtien.springbootmall.model.Product;
import org.springframework.data.relational.core.sql.In;

// ProductService 接口
// 目的: 降低整體程式對 ProductServiceImpl class 的依賴
// hibernate 會自動幫我們創建 bean, 因此不需要使用 @Component
public interface ProductService {

    // 查詢單一商品
    Product getProductById(Integer productId);

    // 新增商品
    Integer createProduct(ProductRequest productRequest);

    // 修改商品
    void updateProduct(Integer productId, ProductRequest productRequest);
}
