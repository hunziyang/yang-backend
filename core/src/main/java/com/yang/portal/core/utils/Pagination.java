package com.yang.portal.core.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@ApiModel(description = "分页条件")
public class Pagination {

    @ApiModelProperty("页码")
    @Min(1)
    private Integer pageNum = 1;
    @ApiModelProperty("每页记录数")
    @Max(1000)
    private Integer pageSize = 20;
    @ApiModelProperty(value = "排序")
    private String orderBy;

    public Integer getOffset() {
        return (pageNum - 1) * pageSize;
    }

}
