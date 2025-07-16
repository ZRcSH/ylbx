package com.neuedu.ylbx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.ylbx.pojo.DiseaseInfo;
import com.neuedu.ylbx.pojo.InpatientDisease;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface InpatientDiseaseMapper extends BaseMapper<InpatientDisease> {


    IPage<DiseaseInfo> selectByPatientId(Page<DiseaseInfo> page, Long patientId);
}