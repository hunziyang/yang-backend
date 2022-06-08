package com.yang.portal.security.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@ApiModel(description = "用户注册")
@Data
public class RegisterVo {

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;
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
