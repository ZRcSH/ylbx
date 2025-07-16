package com.neuedu.ylbx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.ylbx.dto.InpatientDiagnosisDTO;
import com.neuedu.ylbx.dto.InpatientInformationQueryDTO;
import com.neuedu.ylbx.pojo.InpatientDiagnosis;
import com.neuedu.ylbx.vo.DiagnosisTreatmentVo;

public interface InpatientDiagnosisService extends IService<InpatientDiagnosis> {


    void addDiagnosisOrder(InpatientDiagnosisDTO dto);

    IPage<DiagnosisTreatmentVo> queryByPatientId(InpatientInformationQueryDTO queryDTO);
}
