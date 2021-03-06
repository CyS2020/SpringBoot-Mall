package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: CyS2020
 * @date: 2020/12/13
 */
@Data
public class UserLoginForm {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank
    private String password;
}
