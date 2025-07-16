package com.neuedu.ylbx.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.ylbx.dto.InpatientDiseaseDTO;
import com.neuedu.ylbx.dto.InpatientInformationQueryDTO;
import com.neuedu.ylbx.mapper.InpatientDiseaseMapper;
import com.neuedu.ylbx.pojo.DiseaseInfo;
import com.neuedu.ylbx.pojo.InpatientDisease;
import com.neuedu.ylbx.pojo.InpatientMedical;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.ylbx.service.InpatientDiseaseService;

import java.time.LocalDateTime;

@Service
public class InpatientDiseaseServiceimpl extends ServiceImpl<InpatientDiseaseMapper, InpatientDisease> implements InpatientDiseaseService{


    @Override
    public void addInpatientDisease(InpatientDiseaseDTO inpatientDiseaseDTO) {
        InpatientDisease entity = new InpatientDisease();
        entity.setPatientId(inpatientDiseaseDTO.getPatientId());
        entity.setDiseaseId(inpatientDiseaseDTO.getDiseaseId());
        entity.setDiseaseType(inpatientDiseaseDTO.getDiseaseType());
        entity.setOrderTime( LocalDateTime.now()); // 自动设置当前时间为诊断时间

        // 插入数据
        this.save(entity);
    }

    @Override
    public IPage<DiseaseInfo> queryByPatientId(InpatientInformationQueryDTO queryDTO) {
        Page<DiseaseInfo> page = new Page<>(queryDTO.getPageNum(), queryDTO.getPageSize());
        return baseMapper.selectByPatientId(page, queryDTO.getPatientId());
    }
}
