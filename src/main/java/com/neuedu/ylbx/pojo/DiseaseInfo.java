package com.neuedu.ylbx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("疾病信息")
@TableName("disease_info")
public class DiseaseInfo {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("疾病编码")
    private String diseaseCode;

    @ApiModelProperty("疾病名称")
    private String diseaseName;

    @ApiModelProperty("国际疾病ICD编码")
    private String diseaseICD;

    @ApiModelProperty("疾病类型")
    private String diseaseCategory;
}
