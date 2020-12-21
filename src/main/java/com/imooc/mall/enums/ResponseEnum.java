package com.imooc.mall.enums;

import lombok.Getter;

/**
 * @author: CyS2020
 * @date: 2020/12/12
 */
@Getter
public enum ResponseEnum {

    // -1-服务端错误
    ERROR(-1, "服务端错误"),

    // 0-成功
    SUCCESS(0, "成功"),

    // 1-密码错误
    PASSWORD_ERROR(1, "密码错误"),

    // 2-用户已存在
    USERNAME_EXIST(2, "用户名已存在"),

    // 3-参数错误
    PARAM_ERROR(3, "参数错误"),

    // 4-邮箱已存在
    EMAIL_EXIST(4, "邮箱已存在"),

    // 10-用户未登陆, 请先登陆;
    NEED_LOGIN(10, "用户未登陆, 请先登陆"),

    // 11-用户名或密码错误
    USERNAME_OR_PASSWORD_ERROR(11, "用户名或密码错误"),

    // 12-商品下架或者删除
    PRODUCT_OFF_SALE_OR_DELETE(12, "商品下架或删除"),

    // 13-商品不存在
    PRODUCT_NOT_EXIST(13, "商品不存在"),

    // 14-库存有误
    PRODUCT_STOCK_ERROR(14, "库存不正确"),

    // 15-购物车里商品不存在
    CART_PRODUCT_NOT_EXIST(15, "购物车里无此商品");

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
