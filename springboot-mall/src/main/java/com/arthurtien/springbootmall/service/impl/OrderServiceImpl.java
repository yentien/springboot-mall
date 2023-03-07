package com.arthurtien.springbootmall.service.impl;

import com.arthurtien.springbootmall.dao.OrderDao;
import com.arthurtien.springbootmall.dao.ProductDao;
import com.arthurtien.springbootmall.dto.BuyItem;
import com.arthurtien.springbootmall.dto.CreateOrderRequest;
import com.arthurtien.springbootmall.model.OrderItem;
import com.arthurtien.springbootmall.model.Product;
import com.arthurtien.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional   // 確保多個資料庫操作 同時新增成功/失敗 (all or never)
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總價錢
            int amount = product.getPrice() * buyItem.getQuantity();
            totalAmount += amount;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(product.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        // 建立訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId,orderItemList);

        return orderId;
    }
}
