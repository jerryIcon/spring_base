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
@ApiModel(value="TbUserinfo对象", description="")
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户pkID")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @ApiModelProperty(value = "user主键")
    private Integer fkId;

    @ApiModelProperty(value = "用户名手机号")
    private String phone;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "身份角色")
    private String role;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "大学")
    private String university;

    @ApiModelProperty(value = "头像")
    private String picture;

    @ApiModelProperty(value = "个性签名")
    private String signature;

    @ApiModelProperty(value = "删除")
    @TableLogic
    private Boolean isDelete;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
