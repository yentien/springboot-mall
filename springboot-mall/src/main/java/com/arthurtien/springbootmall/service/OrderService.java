package com.arthurtien.springbootmall.service;

import com.arthurtien.springbootmall.dto.CreateOrderRequest;
import com.arthurtien.springbootmall.dto.OrderQueryParams;
import com.arthurtien.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}
