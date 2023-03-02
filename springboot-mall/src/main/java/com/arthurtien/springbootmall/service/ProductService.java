package com.arthurtien.springbootmall.service;

import com.arthurtien.springbootmall.dto.ProductQueryParams;
import com.arthurtien.springbootmall.dto.ProductRequest;
import com.arthurtien.springbootmall.model.Product;

import java.util.List;

// ProductService 接口
// 目的: 降低整體程式對 ProductServiceImpl class 的依賴
// hibernate 會自動幫我們創建 bean, 因此不需要使用 @Component
public interface ProductService {

    // 查詢商品總數
    Integer countProduct(ProductQueryParams productQueryParams);

    // 查詢商品列表
    List<Product> getProducts(ProductQueryParams productQueryParams);

    // 查詢單一商品
    Product getProductById(Integer productId);

    // 新增商品
    Integer createProduct(ProductRequest productRequest);

    // 修改商品
    void updateProduct(Integer productId, ProductRequest productRequest);

    // 刪除商品
    void deleteProductById(Integer productId);
}
