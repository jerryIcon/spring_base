package com.ar.serviceucenter.filter;

/**
 * @author JerryIcon
 * @create 2022-01-05 10:48
 */

import com.ar.commonutils.JwtUtils;
import com.ar.commonutils.exceptionhandler.GuliException;
import com.ar.serviceucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 自定义拦截器
 */
@Component
public class TokenInterceotor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    //注入StringRedisTemplate
    @Autowired
    private StringRedisTemplate stringRedisTemplate;  //key  value 都是字符串

    //前置处理器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("进入了前置处理器");
        String token = request.getHeader("token");
        //System.out.println("token"+token);
        if (StringUtils.isEmpty(token)||token.equals("null")) {
            response.setStatus(401);
            return false;
        }
        /*
            1.checkToken
            2.解析token =>id
            3.判断token在不在redis里面，如果存在比对，比对成功通过，比对不成功替换。
         */
        try {
            JwtUtils.checkToken(token);
            String id = JwtUtils.getMemberIdByJwtToken(token);
            if(stringRedisTemplate.hasKey("userid:"+id)){
                String value= stringRedisTemplate.opsForValue().get("userid:"+id);
                if(value.equals(token)){
                    return true;
                }else{
                    throw new GuliException();
                }
            }
        }catch (StringIndexOutOfBoundsException e){
            e.printStackTrace();
            throw new GuliException(20001,"非法token！");
        }
        catch (Exception e){
            e.printStackTrace();
            throw new GuliException(20001,"账号过期，请重新登入！");
        }
        throw new GuliException(20001,"请重新登入！");
    }
}
