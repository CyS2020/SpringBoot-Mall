package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: CyS2020
 * @date: 2020/12/24
 */
@Data
public class OrderCreateForm {

    @NotNull
    private Integer shippingId;
}
