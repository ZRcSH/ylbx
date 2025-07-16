package com.neuedu.ylbx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("患者医嘱诊疗DTO")
public class InpatientDiagnosisDTO {
    @ApiModelProperty(value = "患者ID")
    private Long patientId;          // 患者ID
    @ApiModelProperty(value = "诊疗项目ID")
    private Integer diagnosisId;        // 诊疗项目ID
    @ApiModelProperty(value = "医生医嘱诊疗项目信息")
    private String doctorOrder;      // 医生医嘱诊疗项目信息
    @ApiModelProperty(value = "用法详情说明")
    private String useMethod;        // 用法详情说明
    @ApiModelProperty(value = "医嘱状态（1-正常执行, 0-作废, 2-停止）")
    private Integer status;          // 医嘱状态（1-正常执行, 0-作废, 2-停止）
}