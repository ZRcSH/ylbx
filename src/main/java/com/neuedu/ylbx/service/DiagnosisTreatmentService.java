package com.neuedu.ylbx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.ylbx.dto.DiagnosisTreatmentPageDTO;
import com.neuedu.ylbx.pojo.DiagnosisTreatment;

public interface DiagnosisTreatmentService extends IService<DiagnosisTreatment> {
    Page<DiagnosisTreatment> getPage(DiagnosisTreatmentPageDTO dto);

   void deleteCache();
}
