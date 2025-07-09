package com.neuedu.ylbx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("inpatient_medical")
public class InpatientMedical {
    @TableId(type = IdType.AUTO)
    private Integer id;                 // 主键ID
    private LocalDateTime orderTime;    // 开立时间
    private String doctorOrder;         // 医嘱医疗服务信息内容
    private String useMethod;           // 用法详情说明
    private Integer medicalId;          // 医疗服务表外键
    private Integer status;             // 医嘱状态(1-正常执行 0-作废 2-停止)
}
