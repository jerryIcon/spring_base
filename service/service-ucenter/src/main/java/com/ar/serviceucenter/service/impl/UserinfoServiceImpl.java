package com.ar.serviceucenter.service.impl;

import com.ar.commonutils.JwtUtils;
import com.ar.serviceucenter.entity.User;
import com.ar.serviceucenter.entity.Userinfo;
import com.ar.serviceucenter.mapper.UserinfoMapper;
import com.ar.serviceucenter.service.UserinfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JerryIcon
 * @since 2022-01-04
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {


    @Override
    public Userinfo getUserinfo(String id) {
        Userinfo userinfo = baseMapper.selectOne(new QueryWrapper<Userinfo>().eq("fk_id", id));
        return userinfo;
    }
}
