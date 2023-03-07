package com.arthurtien.springbootmall.model;

import lombok.Data;

@Data
public class Order {

    private Integer orderId;
    private Integer userId;
    private Integer totalAmount;
    private Integer createdDate;
    private Integer lastModifiedDate;
}
