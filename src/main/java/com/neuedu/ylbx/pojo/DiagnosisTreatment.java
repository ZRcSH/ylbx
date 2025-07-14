package com.neuedu.ylbx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("诊疗项目信息")
@TableName("diagnosis_treatment")
public class DiagnosisTreatment {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("项目类别")
    private String medicalType;

    @ApiModelProperty("项目编码")
    private String medicalNumber;

    @ApiModelProperty("项目国家编码")
    private String countryNumber;

    @ApiModelProperty("项目名称")
    private String medicalName;

    @ApiModelProperty("项目说明")
    private String medicalInfo;

    @ApiModelProperty("除外内容")
    private String medicalExclude;

    @ApiModelProperty("计价单位")
    private String medicalUnit;

    @ApiModelProperty("价格")
    private BigDecimal medicalPrice;

    @ApiModelProperty("备注")
    private String remark;
}
