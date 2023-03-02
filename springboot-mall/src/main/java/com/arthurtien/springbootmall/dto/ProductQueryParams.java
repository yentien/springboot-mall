package com.arthurtien.springbootmall.dto;

import com.arthurtien.springbootmall.constant.ProductCategory;
import lombok.Data;

@Data
public class ProductQueryParams {

    private ProductCategory category;
    private String search;
}
