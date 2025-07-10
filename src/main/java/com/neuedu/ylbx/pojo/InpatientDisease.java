package com.neuedu.ylbx.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@ApiModel("患者诊断疾病信息")
@TableName("inpatient_disease")
public class InpatientDisease {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("住院患者表外键")
    private Integer patientId;

    @ApiModelProperty("疾病表外键")
    private Integer diseaseId;

    @ApiModelProperty("疾病诊断时间")
    private LocalDateTime orderTime;

    @ApiModelProperty("诊断类型(1-入院诊断 2-主要诊断 3-其他诊断)")
    private Integer diseaseType;
}