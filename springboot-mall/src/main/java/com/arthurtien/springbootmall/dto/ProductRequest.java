// product transfer object
// 目的: 接前端的response

package com.arthurtien.springbootmall.dto;

import com.arthurtien.springbootmall.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {

    @NotNull
    private String productName;
    @NotNull
    private ProductCategory category;
    @NotNull
    private String imageUrl;
    @NotNull
    private Integer price;
    @NotNull
    private Integer stock;

    private String description;
}
