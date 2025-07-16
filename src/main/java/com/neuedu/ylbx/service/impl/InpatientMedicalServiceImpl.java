package com.neuedu.ylbx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.neuedu.ylbx.dto.InpatientMedicalDTO;
import com.neuedu.ylbx.dto.InpatientInformationQueryDTO;
import com.neuedu.ylbx.mapper.InpatientMedicalMapper;
import com.neuedu.ylbx.pojo.InpatientMedical;
import com.neuedu.ylbx.service.InpatientMedicalService;
import com.neuedu.ylbx.vo.DrugInfoVo;
import com.neuedu.ylbx.vo.MedicalServiceVo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InpatientMedicalServiceImpl extends ServiceImpl<InpatientMedicalMapper, InpatientMedical> implements InpatientMedicalService {

    @Override
    public void addDiseaseMedical(InpatientMedicalDTO inpatientMedicalDTO) {
            InpatientMedical entity = new InpatientMedical();
            // 设置开立时间为当前系统时间
            entity.setOrderTime(LocalDateTime.now());
            entity.setDoctorOrder(inpatientMedicalDTO.getDoctorOrder());
            entity.setUseMethod(inpatientMedicalDTO.getUseMethod());
            entity.setMedicalId(inpatientMedicalDTO.getMedicalId());
            entity.setPatientId(inpatientMedicalDTO.getPatientId());
            entity.setStatus(inpatientMedicalDTO.getStatus());

            // 插入数据
            this.save(entity);
    }

    @Override
    public IPage<MedicalServiceVo> queryByPatientId(InpatientInformationQueryDTO queryDTO) {
        Page<MedicalServiceVo> page = new Page<>(queryDTO.getPageNum(), queryDTO.getPageSize());
        return baseMapper.selectByPatientId(page, queryDTO.getPatientId());
    }
}
