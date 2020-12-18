package com.imooc.mall.service;

import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;

/**
 * @author: CyS2020
 * @date: 2020/12/18
 */
public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm form);
}
