package com.neuedu.ylbx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.ylbx.pojo.InpatientMedical;
import com.neuedu.ylbx.vo.DrugInfoVo;
import com.neuedu.ylbx.vo.MedicalServiceVo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface InpatientMedicalMapper extends BaseMapper<InpatientMedical> {

    // 分页查询方法
    IPage<MedicalServiceVo> selectByPatientId(Page<MedicalServiceVo> page, Long patientId);
}
