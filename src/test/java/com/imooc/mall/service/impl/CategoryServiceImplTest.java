package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.dao.CategoryMapper;
import com.imooc.mall.pojo.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: CyS2020
 * @date: 2020/12/13
 */
public class CategoryServiceImplTest extends MallApplicationTests {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void loadAllCategory() {
        List<Category> categories = categoryMapper.selectAll();
    }
}