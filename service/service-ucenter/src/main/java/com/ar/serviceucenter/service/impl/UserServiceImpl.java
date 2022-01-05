package com.ar.serviceucenter.service.impl;

import com.ar.commonutils.JwtUtils;
import com.ar.commonutils.MD5;
import com.ar.commonutils.exceptionhandler.GuliException;
import com.ar.serviceucenter.entity.User;
import com.ar.serviceucenter.entity.Userinfo;
import com.ar.serviceucenter.mapper.UserMapper;
import com.ar.serviceucenter.service.UserService;
import com.ar.serviceucenter.service.UserinfoService;
import com.ar.serviceucenter.vo.LoginVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JerryIcon
 * @since 2022-01-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //注入StringRedisTemplate
    @Autowired
    private StringRedisTemplate stringRedisTemplate;  //key  value 都是字符串

    @Autowired
    private UserinfoService userinfoService;

    /**
     * 会员登录
     * @param loginVo
     * @return
     */
    @Override
    public String login(LoginVo loginVo) {
        String phone = loginVo.getPhone();
        String password = loginVo.getPasswd();

        //校验参数
        if(StringUtils.isEmpty(phone) ||
                StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(phone)) {
            throw new GuliException(20001,"error");
        }

        //获取会员
        User user = baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getPhone,phone));
        if(null == user) {
            throw new GuliException(20001,"error");
        }

        //校验密码
        if(!MD5.encrypt(password).equals(user.getPasswd())) {
            throw new GuliException(20001,"error");
        }

        //校验是否被禁用
        if(user.getIsDisabled()) {
            throw new GuliException(20001,"error");
        }

        //使用JWT生成token字符串
        String token = JwtUtils.getJwtToken(String.valueOf(user.getId()), user.getPhone());
        System.out.println(token);
        //修改key序列化方案   String类型序列
//        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        //修改hash key 序列化方案
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        stringRedisTemplate.opsForValue().set("userid:"+user.getId(),token, Duration.ofDays(30));
        return token;
    }

}
