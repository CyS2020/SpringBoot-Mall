package com.imooc.mall.service.impl;

import com.imooc.mall.consts.MallConst;
import com.imooc.mall.dao.CategoryMapper;
import com.imooc.mall.pojo.Category;
import com.imooc.mall.service.ICategoryService;
import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: CyS2020
 * @date: 2020/12/13
 */
@Service
@Slf4j
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryVo> loadAllCategory() {
        List<Category> categories = categoryMapper.selectAll();
        Map<Integer, CategoryVo> categoryDtoMap = new HashMap<>();
        for (Category category : categories) {
            log.info("当前类目={}", category.getId());
            CategoryVo categoryVo = new CategoryVo();
            categoryVo.setId(category.getId());
            categoryVo.setParentId(category.getParentId());
            categoryVo.setName(category.getName());
            categoryVo.setSubCategories(new ArrayList<>());
            categoryDtoMap.put(category.getId(), categoryVo);
            if (category.getParentId() == 0) {
                categoryVo.setSortOrder(1);
            } else {
                CategoryVo parentCategory = categoryDtoMap.get(category.getParentId());
                categoryVo.setSortOrder(parentCategory.getSortOrder() + 1);
                parentCategory.getSubCategories().add(categoryVo);
            }
        }
        List<CategoryVo> categoryVos = new ArrayList<>();
        for (Map.Entry<Integer, CategoryVo> entry : categoryDtoMap.entrySet()) {
            if (entry.getValue().getSortOrder() == 1) {
                categoryVos.add(entry.getValue());
            }
        }
        return categoryVos;
    }

    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
        List<Category> categories = categoryMapper.selectAll();

        // lambda + stream
        List<CategoryVo> categoryVoList = categories.stream()
                .filter(category -> category.getParentId().equals(MallConst.ROOT_PARENT_ID))
                .map(this::category2CategoryVo)
                .collect(Collectors.toList());

        // 查询子目录
        findSubCategory(categoryVoList, categories);
        return ResponseVo.success(categoryVoList);
    }

    private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories) {
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();
            for (Category category : categories) {
                // 如果查找内容, 设置subCategory, 继续往下查
                if (category.getParentId().equals(categoryVo.getId())) {
                    subCategoryVoList.add(category2CategoryVo(category));
                }
            }
            categoryVo.setSubCategories(subCategoryVoList);
            findSubCategory(subCategoryVoList, categories);
        }
    }

    private CategoryVo category2CategoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }
}
