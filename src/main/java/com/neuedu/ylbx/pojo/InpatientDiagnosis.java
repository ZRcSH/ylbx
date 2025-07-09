package com.neuedu.ylbx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("inpatient_diagnosis")
public class InpatientDiagnosis {
    @TableId(type = IdType.AUTO)
    private Integer id;                 // 主键ID
    private LocalDateTime orderTime;    // 开立时间
    private String doctorOrder;         // 医生医嘱诊疗项目信息
    private String useMethod;           // 用法详情说明
    private Integer diagnosisId;        // 诊疗项目表外键
    private Integer status;             // 医嘱状态(1-正常执行 0-作废 2-停止)
}
