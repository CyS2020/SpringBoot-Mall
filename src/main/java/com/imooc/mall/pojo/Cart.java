package com.imooc.mall.pojo;

import lombok.Data;

/**
 * @author: CyS2020
 * @date: 2020/12/18
 */
@Data
public class Cart {

    private Integer productId;

    private Integer quantity;

    private Boolean productSelected;

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
