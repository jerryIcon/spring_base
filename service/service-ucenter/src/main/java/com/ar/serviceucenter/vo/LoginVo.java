package com.ar.serviceucenter.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author JerryIcon
 * @create 2022-01-04 21:11
 */
@Data
@ApiModel(value="账号密码登入", description="账号密码登入")
public class LoginVo {
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "密码")
    private String passwd;

}
