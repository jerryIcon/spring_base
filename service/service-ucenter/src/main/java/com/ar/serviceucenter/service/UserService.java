package com.ar.serviceucenter.service;

import com.ar.serviceucenter.entity.User;
import com.ar.serviceucenter.vo.LoginVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author JerryIcon
 * @since 2022-01-04
 */
@Service
public interface UserService extends IService<User> {

    /**
     * 登入
     * @param loginVo
     * @return
     */
    String login(LoginVo loginVo);

}
