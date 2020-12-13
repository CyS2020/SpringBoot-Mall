package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: CyS2020
 * @date: 2020/12/13
 */
@Data
public class UserRegisterForm {

    // @NotBlank 用于string判断空格
    // @NotEmpty 用于集合判断数组空
    // @NotNull  判断是否为null
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
