package com.ar.serviceucenter.controller;


import com.ar.commonutils.JwtUtils;
import com.ar.commonutils.R;
import com.ar.commonutils.exceptionhandler.GuliException;
import com.ar.serviceucenter.entity.Userinfo;
import com.ar.serviceucenter.service.UserService;
import com.ar.serviceucenter.service.UserinfoService;
import com.ar.serviceucenter.vo.LoginVo;
import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JerryIcon
 * @since 2022-01-04
 */
@RestController
@RequestMapping("/api/userinfo")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @ApiOperation(value = "根据token获取用户信息")
    @GetMapping("/get")
    public R login(HttpServletRequest request) {
       try {
           String id = JwtUtils.getMemberIdByJwtToken(request);
           Userinfo userinfo = userinfoService.getUserinfo(id);
           return R.ok().data("userinfo", userinfo);
       } catch (ExpiredJwtException e){
           e.printStackTrace();
           throw new GuliException(20001,"登入过期，请重新登入！");
       }
       catch (Exception e){
           e.printStackTrace();
           throw new GuliException(20001,"error");
       }
    }
}

