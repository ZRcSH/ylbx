package com.neuedu.ylbx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.ylbx.pojo.InpatientDiagnosis;
import com.neuedu.ylbx.vo.DiagnosisTreatmentVo;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;

public interface InpatientDiagnosisMapper extends BaseMapper<InpatientDiagnosis> {


    IPage<DiagnosisTreatmentVo> selectByPatientId(Page<DiagnosisTreatmentVo> page, Long patientId);
}
