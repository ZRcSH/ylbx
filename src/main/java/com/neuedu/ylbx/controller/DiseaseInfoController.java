package com.neuedu.ylbx.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.ylbx.dto.DiseaseInfoPageDTO;
import com.neuedu.ylbx.pojo.DiseaseInfo;
import com.neuedu.ylbx.service.DiseaseInfoService;
import com.neuedu.ylbx.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disease")
@Api(tags = "疾病信息管理")
public class DiseaseInfoController {

    @Autowired
    private DiseaseInfoService diseaseInfoService;

    // 新增疾病
    @PostMapping
    @ApiOperation("新增疾病")
    public ResultVo  addDisease(@RequestBody DiseaseInfo entity) {
        diseaseInfoService.save(entity);
        diseaseInfoService.deleteCache();
        return ResultVo.ok("新增成功");
    }

    // 根据ID删除
    @DeleteMapping
    @ApiOperation("根据ID删除疾病")
    public ResultVo delete(@RequestParam List<Integer> ids) {
         diseaseInfoService.removeByIds(ids);
        diseaseInfoService.deleteCache();
         return  ResultVo.ok("删除成功");

    }

    // 更新疾病信息
    @PutMapping
    @ApiOperation("更新疾病信息")
    public ResultVo update(@RequestBody DiseaseInfo entity) {
         diseaseInfoService.updateById(entity);
        diseaseInfoService.deleteCache();
         return ResultVo.ok("更新成功");

    }

    // 根据ID查询
    @GetMapping("/{id}")
    @ApiOperation("根据ID查询疾病详情")
    public ResultVo getById(@PathVariable Integer id) {
        DiseaseInfo entity = diseaseInfoService.getById(id);
        return ResultVo.ok(entity);
    }

    // 分页查询（支持名称模糊查询）
    @GetMapping("/page")
    @ApiOperation("疾病分页查询")
    public ResultVo pageQuery(DiseaseInfoPageDTO dto) {
        Page<DiseaseInfo> page = diseaseInfoService.queryPage(dto);
        return ResultVo.ok(page);
    }
}