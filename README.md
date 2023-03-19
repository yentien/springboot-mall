# 電商網站(後端)

## 實作內容
- 查詢商品列表
- 新增/查詢/修改/刪除(CRUD)商品

## 帳號功能
- 註冊帳號
- 登入

## 訂單功能
- 訂單創建
- 查詢訂單列表

## 單元測試


## 資料庫
### table
### product 
| field name | data type |
|:--------:|:--------:|
| product_id | INT |
|product_name|VARCHAR(128)|
|category|VARCHAR(32)|
|image_url|VARCHAR(256)|
|price|INT|
|stock|INT|
|description|VARCHAR(1024)|
|created_date|TIMESTAMP|
|last_modified_date|TIMESTAMP|

### user
| field name | data type |
|:--------:|:--------:|
|user_id|INT|
|email|VARCHAR(256)|
|password|VARCHAR(256)|
|created_date|TIMESTAMP|
|last_modified_date|TIMESTAMP|
 
### order
| field name | data type |
|:--------:|:--------:|
|order_id|INT|
|user_id|INT|
|total_amount|INT|
|created_date|TIMESTAMP|
|last_modified_date|TIMESTAMP|
 
### order_item
| field name | data type |
|:--------:|:--------:|
|order_item_id|INT|
|order_id|INT|
|product_id|INT|
|quantity|INT|
|amount|INT|
