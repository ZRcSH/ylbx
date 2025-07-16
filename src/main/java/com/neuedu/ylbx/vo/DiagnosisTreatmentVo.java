package com.neuedu.ylbx.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DiagnosisTreatmentVo {
    @ApiModelProperty("项目名称")
    private String medicalName;

    @ApiModelProperty("项目编码")
    private String medicalNumber;

    @ApiModelProperty("除外内容")
    private String medicalExclude;

    @ApiModelProperty("计价单位")
    private String medicalUnit;

    @ApiModelProperty("价格")
    private BigDecimal medicalPrice;
}
