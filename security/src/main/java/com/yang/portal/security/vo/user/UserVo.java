package com.yang.portal.security.vo.user;

import com.yang.portal.core.utils.Pagination;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "获取用户")
public class UserVo {

    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("手机号")
    private String phone;

    private Pagination pagination = new Pagination();
}
