package com.yang.portal.security.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色(Rolr)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:27:02
 */
@Data
@TableName("ROLE")
public class Role {
    //主键
    @TableId(type = IdType.AUTO)
    private Long id;
    //角色名
    private String name;
    //角色编码
    private String code;
    //描述
    private String description;
    //是否删除
    private Boolean isDelete;
    //乐观锁
    private Integer revision;
    //创建人ID
    private Long createdId;
    //创建人
    private String createdBy;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    //更新人ID
    private Long updatedId;
    //更新人
    private String updatedBy;
    //更新时间
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updatedTime;

}

