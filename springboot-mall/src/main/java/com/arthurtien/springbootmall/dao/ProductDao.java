package com.arthurtien.springbootmall.dao;

import com.arthurtien.springbootmall.constant.ProductCategory;
import com.arthurtien.springbootmall.dto.ProductQueryParams;
import com.arthurtien.springbootmall.dto.ProductRequest;
import com.arthurtien.springbootmall.model.Product;

import java.util.List;

// ProductDao 接口
// 目的: 降低整體程式對 ProductDaoImpi class 的依賴
// hibernate 會自動幫我們創建 bean, 因此不需要使用 @Component
public interface ProductDao {

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

    // 更新商品庫存
    void updateStock(Integer productId, Integer stock);
}
