package com.neuedu.ylbx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("疾病分页查询DTO")
public class DiseaseInfoPageDTO {
    @ApiModelProperty(value = "当前页码", example = "1")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "每页数量", example = "10")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "疾病名称（支持模糊查询）", example = "肺炎")
    private String diseaseName;
}
