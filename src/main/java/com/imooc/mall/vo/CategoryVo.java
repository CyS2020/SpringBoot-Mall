package com.imooc.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: CyS2020
 * @date: 2020/12/13
 */
@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
