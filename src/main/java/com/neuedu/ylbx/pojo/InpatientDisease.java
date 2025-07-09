package com.neuedu.ylbx.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("inpatient_disease")
public class InpatientDisease {
    @TableId(type = IdType.AUTO)
    private Integer id;                // 主键ID
    private Integer patientId;         // 住院患者表外键
    private Integer diseaseId;         // 疾病表外键
    private LocalDateTime orderTime;   // 疾病诊断时间
    private Integer diseaseType;       // 诊断类型(1-入院诊断 2-主要诊断 3-其他诊断)
}