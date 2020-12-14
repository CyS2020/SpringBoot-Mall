package com.imooc.mall.service;

import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;

/**
 * @author: CyS2020
 * @date: 2020/12/13
 */
public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();
}
