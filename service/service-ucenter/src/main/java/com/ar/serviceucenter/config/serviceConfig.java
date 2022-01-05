package com.ar.serviceucenter.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JerryIcon
 * @create 2022-01-05 9:59
 */
@Configuration
@MapperScan("com.ar.serviceucenter.mapper")
public class serviceConfig {

    /**
     * 逻辑删除
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
