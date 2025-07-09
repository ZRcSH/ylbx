package com.neuedu.ylbx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("disease_info")
public class DiseaseInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;                // 主键ID
    private String diseaseCode;        // 疾病编码
    private String diseaseName;        // 疾病名称
    private String diseaseICD;         // 国际疾病ICD编码
    private String diseaseCategory;    // 疾病类型
}
