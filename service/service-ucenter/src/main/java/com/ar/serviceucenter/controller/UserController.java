package com.ar.serviceucenter.controller;


import com.ar.commonutils.R;
import com.ar.serviceucenter.service.UserService;
import com.ar.serviceucenter.vo.LoginVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JerryIcon
 * @since 2022-01-04
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "会员登录")
    @PostMapping("/login")
    public R login(@RequestBody LoginVo loginVo) {
        String token = userService.login(loginVo);
        return R.ok().data("token", token);
    }
}

