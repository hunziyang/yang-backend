package com.yang.portal.core.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    @Id
    private Long id;
    //描述
    private String description;
    //是否删除
    @TableLogic
    private Boolean isDelete;

    //乐观锁
    @Version
    private Integer revision;
    //创建人ID
    private Long createdId;
    //创建人
    private String createdBy;

    //创建时间
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private ZonedDateTime createdTime;
    //更新人ID
    private Long updatedId;
    //更新人
    private String updatedBy;

    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private ZonedDateTime updatedTime;
}
