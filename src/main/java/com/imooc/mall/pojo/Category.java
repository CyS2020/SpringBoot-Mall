package com.imooc.mall.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author: CyS2020
 * @date: 2020/12/6
 */
@Data
public class Category {
    private Integer id;
    private Integer parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Date createTime;
    private Date updateTime;
}
