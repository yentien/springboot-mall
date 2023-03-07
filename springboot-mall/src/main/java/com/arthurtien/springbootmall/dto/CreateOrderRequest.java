package com.arthurtien.springbootmall.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    @NotEmpty
    private List<BuyItem> buyItemList;

//    public List<BuyItem> getBuyItemList() {
//        return buyItemList;
//    }
//
//    public void setBuyItemList(List<BuyItem> buyItemList) {
//        this.buyItemList = buyItemList;
//    }
}
