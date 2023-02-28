package com.arthurtien.springbootmall.controller;

import com.arthurtien.springbootmall.model.Product;
import com.arthurtien.springbootmall.service.ProductSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductSercice productSercice;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
         Product product = productSercice.getProductById(productId);

         if (product != null) {
             return ResponseEntity.status(HttpStatus.OK).body(product);
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
    }
}
