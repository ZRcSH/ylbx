package com.neuedu.ylbx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.ylbx.dto.DrugInfoPageDTO;
import com.neuedu.ylbx.pojo.DrugInfo;
import com.neuedu.ylbx.service.DrugInfoService;
import com.neuedu.ylbx.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drugInfo")
@Api(tags = "药品信息维护")
public class DrugInfoController {

    @Autowired
    private DrugInfoService drugInfoService;

    // 新增药品信息
    @PostMapping
    @ApiOperation("新增药品信息 ")
    public ResultVo saveDrugInfo(@RequestBody DrugInfo drugInfo) {
        drugInfoService.save(drugInfo);
        drugInfoService.deleteCache();
        return ResultVo.ok("新增药品成功");
    }

    // 根据 ID 删除药品信息
    @DeleteMapping
    @ApiOperation(" 根据ID批量删除药品信息")
    public ResultVo deleteDrugInfo(@RequestParam List<Integer> ids) {
        drugInfoService.removeByIds(ids);
        drugInfoService.deleteCache();
        return ResultVo.ok("删除成功");
    }

    // 根据 ID 更新药品信息
    @PutMapping
    @ApiOperation(" 根据 ID 更新药品信息")
    public ResultVo updateDrugInfo(@RequestBody DrugInfo drugInfo) {
         drugInfoService.updateById(drugInfo);
        drugInfoService.deleteCache();
        return ResultVo.ok("更新成功");
    }

    // 分页查询药品信息
    @GetMapping("/page")
    @ApiOperation("分页查询药品信息")
    public ResultVo pageQuery(DrugInfoPageDTO dto) {
         IPage<DrugInfo> page = drugInfoService.pageQuery(dto);
        return ResultVo.ok(page);
    }

    // 根据 ID 查询药品信息
    @GetMapping("/{id}")
    @ApiOperation("根据 ID 查询药品信息")
    public ResultVo getDrugInfoById(@PathVariable Integer id) {
         DrugInfo item =drugInfoService.getById(id);
         return ResultVo.ok(item);
    }
}
