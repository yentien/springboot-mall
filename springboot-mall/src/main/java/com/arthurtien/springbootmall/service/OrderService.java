package com.arthurtien.springbootmall.service;

import com.arthurtien.springbootmall.dto.CreateOrderRequest;
import com.arthurtien.springbootmall.model.Order;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
