package com.neuedu.ylbx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.ylbx.dto.InpatientDiseaseDTO;
import com.neuedu.ylbx.dto.InpatientInformationQueryDTO;
import com.neuedu.ylbx.pojo.DiseaseInfo;
import com.neuedu.ylbx.pojo.InpatientDisease;

public interface InpatientDiseaseService extends IService<InpatientDisease> {



    void addInpatientDisease(InpatientDiseaseDTO entity);

    IPage<DiseaseInfo> queryByPatientId(InpatientInformationQueryDTO queryDTO);
}
