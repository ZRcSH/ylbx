package com.neuedu.ylbx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.ylbx.dto.DiseaseInfoPageDTO;
import com.neuedu.ylbx.pojo.DiseaseInfo;

public interface DiseaseInfoService extends IService<DiseaseInfo> {
     void deleteCache();
    Page<DiseaseInfo> queryPage(DiseaseInfoPageDTO dto);
}