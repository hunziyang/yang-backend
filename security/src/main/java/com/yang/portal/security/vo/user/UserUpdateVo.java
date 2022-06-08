package com.yang.portal.security.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@ApiModel(description = "更新用户")
@Data
public class UserUpdateVo {

    @ApiModelProperty(value = "真实姓名")
    private String name;
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号")
    private String phone;
    @NotBlank(message = "昵称不能为空")
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "生日")
    private LocalDate birthday;
}
