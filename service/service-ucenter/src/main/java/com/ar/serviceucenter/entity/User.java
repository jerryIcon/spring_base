package com.ar.serviceucenter.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author JerryIcon
 * @since 2022-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TbUser对象", description="")
public class User implements Serializable  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户pkID")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @ApiModelProperty(value = "密码限制16位")
    private String passwd;

    @ApiModelProperty(value = "区号")
    private Integer code;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "禁用")
    private Boolean isDisabled;

    @ApiModelProperty(value = "删除")
    @TableLogic
    private Boolean isDelete;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
