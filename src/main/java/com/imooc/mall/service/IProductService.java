package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.vo.ProductDetailVo;
import com.imooc.mall.vo.ResponseVo;

/**
 * @author: CyS2020
 * @date: 2020/12/15
 */
public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
