package com.neuedu.ylbx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("诊疗项目分页查询DTO")
public class DiagnosisTreatmentPageDTO {
    @ApiModelProperty("当前页码")
    private Integer pageNum = 1;

    @ApiModelProperty("每页条数")
    private Integer pageSize = 10;

    @ApiModelProperty("项目名称（模糊查询）")
    private String medicalName;
}