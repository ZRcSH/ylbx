package com.neuedu.ylbx.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DrugInfoPageDTO {
    @ApiModelProperty(value = "当前页码", example = "1")
    private Integer pageNum;
    @ApiModelProperty(value = "每页数量", example = "10")
    private Integer pageSize;
    @ApiModelProperty(value = "药品中文名称，用于模糊查询", example = "肺炎")
    private String chinaName; // 药品中文名称，用于模糊查询
}
