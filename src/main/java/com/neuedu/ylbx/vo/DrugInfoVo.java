package com.neuedu.ylbx.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DrugInfoVo {
    @ApiModelProperty("药品中文名称")
    private String chinaName;

    @ApiModelProperty("规格")
    private String specifications;

    @ApiModelProperty("单位")
    private String drugUnit;

    @ApiModelProperty("生产企业")
    private String drugManufacturer;

    @ApiModelProperty("价格")
    private BigDecimal drugPrice;
}
