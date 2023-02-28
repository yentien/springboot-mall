package com.arthurtien.springbootmall.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {

    Integer product_id;
    String product_name;
    String category;
    String image_url;
    Integer price;
    Integer stock;
    String description;
    Date created_date;
    Date last_modified_date;
}
