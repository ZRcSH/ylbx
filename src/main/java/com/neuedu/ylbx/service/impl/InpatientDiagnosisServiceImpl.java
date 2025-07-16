package com.neuedu.ylbx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.ylbx.dto.InpatientDiagnosisDTO;
import com.neuedu.ylbx.dto.InpatientInformationQueryDTO;
import com.neuedu.ylbx.mapper.InpatientDiagnosisMapper;
import com.neuedu.ylbx.pojo.InpatientDiagnosis;
import com.neuedu.ylbx.pojo.InpatientDisease;
import com.neuedu.ylbx.service.InpatientDiagnosisService;
import com.neuedu.ylbx.vo.DiagnosisTreatmentVo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InpatientDiagnosisServiceImpl extends ServiceImpl<InpatientDiagnosisMapper, InpatientDiagnosis>
        implements InpatientDiagnosisService {

    @Override
    public void addDiagnosisOrder(InpatientDiagnosisDTO dto) {
        InpatientDiagnosis entity = new InpatientDiagnosis();
        // 设置开立时间为当前系统时间
        entity.setOrderTime(LocalDateTime.now());
        entity.setDoctorOrder(dto.getDoctorOrder());
        entity.setUseMethod(dto.getUseMethod());
        entity.setDiagnosisId(dto.getDiagnosisId());
        entity.setPatientId(dto.getPatientId());
        entity.setStatus(dto.getStatus());

        // 插入数据
        this.save(entity);
    }

    @Override
    public IPage<DiagnosisTreatmentVo> queryByPatientId(InpatientInformationQueryDTO queryDTO) {
        Page<DiagnosisTreatmentVo> page = new Page<>(queryDTO.getPageNum(), queryDTO.getPageSize());
        return baseMapper.selectByPatientId(page, queryDTO.getPatientId());
    }
}
