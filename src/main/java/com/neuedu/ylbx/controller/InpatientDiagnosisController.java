package com.neuedu.ylbx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.ylbx.dto.InpatientDiagnosisDTO;
import com.neuedu.ylbx.dto.InpatientInformationQueryDTO;
import com.neuedu.ylbx.pojo.InpatientDiagnosis;
import com.neuedu.ylbx.service.InpatientDiagnosisService;
import com.neuedu.ylbx.utils.ResultVo;
import com.neuedu.ylbx.vo.DiagnosisTreatmentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inpatientDiagnosis")
@Api(tags = "患者医嘱诊疗项目管理")
public class InpatientDiagnosisController {

    @Autowired
    private InpatientDiagnosisService inpatientDiagnosisService;

    @PostMapping
    @ApiOperation("新增患者医嘱诊疗项目")
    public ResultVo create(@RequestBody InpatientDiagnosisDTO dto) {
       inpatientDiagnosisService.addDiagnosisOrder(dto);
        return ResultVo.ok("新增成功");
    }

    @DeleteMapping
    @ApiOperation("根据ID删除患者医嘱诊疗项目")
    public ResultVo delete(@RequestParam List<Integer> ids) {
        inpatientDiagnosisService.removeByIds(ids);
        return ResultVo.ok("删除成功");
    }

    @PutMapping
    @ApiOperation("更新患者医嘱诊疗项目")
    public ResultVo update(@RequestBody InpatientDiagnosis entity) {
       inpatientDiagnosisService.updateById(entity);
       return ResultVo.ok("更新成功");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询患者医嘱诊疗项目")
    public ResultVo getById(@PathVariable Integer id) {
        InpatientDiagnosis entity = inpatientDiagnosisService.getById(id);
        return ResultVo.ok(entity);
    }
    @PostMapping("/page")
    @ApiOperation("根据患者ID查询医嘱诊疗项目")
    public ResultVo queryPageByPatientId(InpatientInformationQueryDTO queryDTO) {
        IPage<DiagnosisTreatmentVo> resultPage = inpatientDiagnosisService.queryByPatientId(queryDTO);
        return ResultVo.ok(resultPage);
    }

}
