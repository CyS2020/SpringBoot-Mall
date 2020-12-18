package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.service.ICartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: CyS2020
 * @date: 2020/12/18
 */
public class CartServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    @Test
    public void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(26);
        form.setSelected(true);
        cartService.add(1, form);
    }
}