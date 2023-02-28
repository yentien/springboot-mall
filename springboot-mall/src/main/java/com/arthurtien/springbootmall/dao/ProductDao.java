package com.arthurtien.springbootmall.dao;

import com.arthurtien.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

}
