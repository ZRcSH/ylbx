package com.neuedu.ylbx.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class InpatientInformationQueryDTO {
    @ApiModelProperty(value = "病人ID")
    private Long patientId;    // 病人ID
    @ApiModelProperty(value = "当前页码")
    private Integer pageNum ;   // 当前页码
    @ApiModelProperty(value = "每页数量")
    private Integer pageSize ; // 每页数量
}
