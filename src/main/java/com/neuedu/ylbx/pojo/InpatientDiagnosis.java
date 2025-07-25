package com.neuedu.ylbx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@ApiModel("患者医嘱诊疗项目信息")
@TableName("inpatient_diagnosis")
public class InpatientDiagnosis {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty(value = "患者ID")
    private Long patientId;          // 患者ID

    @ApiModelProperty("开立时间")
    private LocalDateTime orderTime;

    @ApiModelProperty("医生医嘱诊疗项目信息")
    private String doctorOrder;

    @ApiModelProperty("用法详情说明")
    private String useMethod;

    @ApiModelProperty("诊疗项目表外键")
    private Integer diagnosisId;

    @ApiModelProperty("医嘱状态(1-正常执行 0-作废 2-停止)")
    private Integer status;
}
