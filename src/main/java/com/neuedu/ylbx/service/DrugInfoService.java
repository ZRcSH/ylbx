package com.neuedu.ylbx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.ylbx.dto.DrugInfoPageDTO;
import com.neuedu.ylbx.pojo.DrugInfo;

public interface DrugInfoService extends IService<DrugInfo> {

    void deleteCache();
    IPage<DrugInfo> pageQuery(DrugInfoPageDTO dto);
}
