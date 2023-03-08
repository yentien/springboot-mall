package com.arthurtien.springbootmall.dao;

import com.arthurtien.springbootmall.model.Order;
import com.arthurtien.springbootmall.model.OrderItem;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface OrderDao {

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
