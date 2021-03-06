package com.imooc.mall.service;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: CyS2020
 * @date: 2020/12/12
 */
@Transactional
public class IUserServiceTest extends MallApplicationTests {

    public static final String USERNAME = "jack";

    public static final String PASSWORD = "123456";

    public static final String EMAIL = "jack@qq.com";

    @Autowired
    private IUserService userService;


    @Before
    public void register() {
        User user = new User(USERNAME, PASSWORD, EMAIL, RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void login() {
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}