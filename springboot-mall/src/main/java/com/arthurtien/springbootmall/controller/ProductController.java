package com.arthurtien.springbootmall.controller;

import com.arthurtien.springbootmall.dto.ProductRequest;
import com.arthurtien.springbootmall.model.Product;
import com.arthurtien.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    // 注入 bean (ProductService 接口)
    @Autowired
    private ProductService productService;

    // Read - 單一查詢商品
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {

        // 取得該商品資訊
         Product product = productService.getProductById(productId);

         // 判斷是否有從資料庫獲取數據
         if (product != null) {
             // statusCode: 200
             return ResponseEntity.status(HttpStatus.OK).body(product);
         } else {
             // statusCode: 404
             // build() 傳送一個包含 status, header, requestBody 的完整http回應
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
    }

    // Create - 新增商品
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {  // 要加 @Valid, 否則 ProductRequest 的 @NotNull 不會生效

        // 新增商品
        Integer productId = productService.createProduct(productRequest);

        // 取得新增完的商品資訊
        Product product = productService.getProductById(productId);

        // statusCode: 201
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    // Update - 修改商品
    // request(要修改的商品id, 修改資料(沿用新增商品時使用的ProductRequest))
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                  @RequestBody @Valid ProductRequest productRequest) {

        // 檢查 product 是否存在
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            // 修改商品數據, 且不返回值
            productService.updateProduct(productId, productRequest);

            // 取得修改過後的商品數據
            Product updateProduct = productService.getProductById(productId);

            // statusCode: 200
            return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
        }
    }

    // Delete - 刪除商品
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {

        // 刪除商品
        productService.deleteProductById(productId);

        // statusCode: 204
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
