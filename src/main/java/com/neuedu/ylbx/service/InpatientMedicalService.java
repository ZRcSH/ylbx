package com.neuedu.ylbx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.ylbx.dto.InpatientMedicalDTO;
import com.neuedu.ylbx.dto.InpatientInformationQueryDTO;
import com.neuedu.ylbx.pojo.InpatientMedical;
import com.neuedu.ylbx.vo.DrugInfoVo;
import com.neuedu.ylbx.vo.MedicalServiceVo;

public interface InpatientMedicalService extends IService<InpatientMedical> {

    IPage<MedicalServiceVo> queryByPatientId(InpatientInformationQueryDTO queryDTO);
    void addDiseaseMedical(InpatientMedicalDTO entity);
}
