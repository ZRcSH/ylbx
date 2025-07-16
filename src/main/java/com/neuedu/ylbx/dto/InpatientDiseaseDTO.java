package com.neuedu.ylbx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("患者诊断疾病参数")
public class InpatientDiseaseDTO {
    @ApiModelProperty(value = "患者ID")
    private Integer patientId;   // 患者ID
    @ApiModelProperty(value = "疾病ID")
    private Integer diseaseId;   // 疾病ID
    @ApiModelProperty(value = "诊断类型")
    private Integer diseaseType; // 诊断类型
}
