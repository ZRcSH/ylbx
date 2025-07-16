package com.neuedu.ylbx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.ylbx.dto.InpatientMedicalDTO;
import com.neuedu.ylbx.dto.InpatientInformationQueryDTO;
import com.neuedu.ylbx.pojo.InpatientMedical;
import com.neuedu.ylbx.service.InpatientMedicalService;
import com.neuedu.ylbx.utils.ResultVo;
import com.neuedu.ylbx.vo.DrugInfoVo;
import com.neuedu.ylbx.vo.MedicalServiceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inpatient-medical")
@Api(tags = "患者医嘱医疗服务管理")
public class InpatientMedicalController {

    @Autowired
    private InpatientMedicalService inpatientMedicalService;

    @PostMapping
    @ApiOperation("新增患者医嘱医疗服务")
    public ResultVo addDiagnosis(@RequestBody InpatientMedicalDTO entity) {
        inpatientMedicalService.addDiseaseMedical(entity);
        return ResultVo.ok("新增成功");
    }

    @DeleteMapping
    @ApiOperation("根据ID删除患者医嘱医疗服务")
    public ResultVo delete(@RequestParam List<Integer> ids) {
        inpatientMedicalService.removeByIds(ids);
        return ResultVo.ok("删除成功");
    }

    @PutMapping
    @ApiOperation("更新患者医嘱医疗服务")
    public ResultVo update(@RequestBody InpatientMedical entity) {
        inpatientMedicalService.updateById(entity);
        return ResultVo.ok("更新成功");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询患者医嘱医疗服务")
    public ResultVo getById(@PathVariable Integer id) {
        InpatientMedical entity = inpatientMedicalService.getById(id);
        return ResultVo.ok(entity);
    }

    @PostMapping("/page")
    @ApiOperation("根据患者id查询医嘱医疗服务")
    public ResultVo queryPageByPatientId(InpatientInformationQueryDTO queryDTO) {
        IPage<MedicalServiceVo> resultPage = inpatientMedicalService.queryByPatientId(queryDTO);
        return ResultVo.ok(resultPage);
    }

}
