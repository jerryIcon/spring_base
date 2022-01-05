package com.ar.serviceucenter.service;

import com.ar.serviceucenter.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author JerryIcon
 * @since 2022-01-04
 */
public interface UserinfoService extends IService<Userinfo> {

    /**
     * 根据ID获取用户信息
     * @param
     * @return
     */
    Userinfo getUserinfo(String id);

}
