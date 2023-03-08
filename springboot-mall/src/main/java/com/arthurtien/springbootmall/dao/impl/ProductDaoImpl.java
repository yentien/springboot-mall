package com.arthurtien.springbootmall.dao.impl;

import com.arthurtien.springbootmall.dao.ProductDao;
import com.arthurtien.springbootmall.dto.ProductQueryParams;
import com.arthurtien.springbootmall.dto.ProductRequest;
import com.arthurtien.springbootmall.model.Product;
import com.arthurtien.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 實作 ProductDao 接口
// 目的: 降低整體程式對 ProductDao class 的依賴

// 創建 bean
@Component
public class ProductDaoImpl implements ProductDao {

    // 注入 bean
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // 查詢商品總數
    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
       String sql = "SELECT count(*) FROM product WHERE 1=1";

       Map<String, Object> map = new HashMap<>();

        // 查詢條件
        sql = addfilteringSql(sql, map, productQueryParams);

       Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);

        return total;
    }

    // 查詢商品列表
    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql = "SELECT product_id, product_name, category, image_url, price," +
                " stock, description, created_date, last_modified_date " +
                "FROM product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        // 查詢條件
        sql = addfilteringSql(sql, map, productQueryParams);

        // 排序
        // orderBy 的sql語法 只能用字串拼接的方式, 沒辦法用sql變數
        sql = sql + " ORDER BY " + productQueryParams.getOrderBy() + " " + productQueryParams.getSort();

        // 分頁
        // limit & offset 要放在 orderBy 後面
        sql = sql + " LIMIT :limit OFFSET :offset";
        map.put("limit", productQueryParams.getLimit());
        map.put("offset", productQueryParams.getOffset());

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }

    // 查詢單一商品
    @Override
    public Product getProductById(Integer productId) {

        // 向資料庫查詢的 sql 語法
        String sql = "SELECT product_id, product_name, category, image_url, " +
                "price, stock, description, created_date, last_modified_date " +
                "FROM product WHERE product_id = :productId";

        // 使用 HashMap 以 key-value pair 的方式來存放 request 傳進來的參數
        // 目的: 使 sql 找得到對應 key 並 帶入對應 value
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        // 一次查詢 namedParameterJdbcTemplate.query 須帶入三個參數, 並會返回一個 List
        // 目的: 一次性發送多個查詢結果, 減少資料庫查詢負擔; 可使用此來 sql語法可帶入命名參數, 增加程式可讀性和可維護性
        // 自訂義rowMapper, return Product object
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        // 檢核是否有值
        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }

    // 新增商品
    @Override
    public Integer createProduct(ProductRequest productRequest) {

        String sql = "INSERT INTO product(product_name, category, image_url, price," +
                " stock, description, created_date, last_modified_date) " +
                "VALUES (:productName, :category, :imageUrl, :price, :stock," +
                " :description, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());

        // productRequest.getCategory() 類型為 Enum, 而資料庫 category 欄位是VarChar,
        // 因此要轉換成 String 類型才不會跳錯
        map.put("category", productRequest.getCategory().toString());

        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        // 取得當前時間並放入 table 欄位中
        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        // 使用 KeyHolder 目的: 取得更新或插入時自動生成的productId
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // update與query差別, 使用MapSqlParameterSource()作為第二個參數
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        // 取得更新或插入時自動生成的productId
        Integer productId = keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product " +
                "SET product_name = :productName, category = :category," +
                " image_url = :imageUrl, price = :price, stock = :stock," +
                " description = :description, last_modified_date = :lastModifiedDate " +
                " WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void updateStock(Integer productId, Integer stock) {
        String sql = "UPDATE product SET stock = :stock, last_modified_date = :lastModifiedDate WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("stock", stock);
        map.put("productId", productId);
        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }

    private String addfilteringSql(String sql, Map<String, Object> map, ProductQueryParams productQueryParams) {
        if (productQueryParams.getCategory() != null) {
            sql = sql + " AND category = :category";
            map.put("category", productQueryParams.getCategory().name()); // enum 類型, 使用name()方法轉換成字串
        }

        if (productQueryParams.getSearch() != null) {
            sql = sql + " AND product_name LIKE :search";
            map.put("search", "%" + productQueryParams.getSearch()  + "%");
        }

        return sql;
    }
}
