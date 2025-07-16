package com.neuedu.ylbx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.ylbx.dto.InpatientDiseaseDTO;
import com.neuedu.ylbx.dto.InpatientInformationQueryDTO;
import com.neuedu.ylbx.pojo.DiseaseInfo;
import com.neuedu.ylbx.pojo.InpatientDisease;
import com.neuedu.ylbx.service.InpatientDiseaseService;
import com.neuedu.ylbx.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inpatient-disease")
@Api(tags = "患者诊断疾病管理")
public class InpatientDiseaseController {

    @Autowired
    private InpatientDiseaseService inpatientDiseaseService;

    @PostMapping
    @ApiOperation("新增患者诊断疾病")
    public ResultVo addDiagnosis(@RequestBody InpatientDiseaseDTO entity) {
        inpatientDiseaseService.addInpatientDisease(entity);
        return ResultVo.ok("新增成功");
    }

    @DeleteMapping
    @ApiOperation("根据ID删除患者诊断疾病")
    public ResultVo delete(@RequestParam List<Integer> ids) {
        inpatientDiseaseService.removeByIds(ids);
        return ResultVo.ok("删除成功");
    }

    @PutMapping
    @ApiOperation("更新患者诊断疾病")
    public ResultVo update(@RequestBody InpatientDisease entity) {
        inpatientDiseaseService.updateById(entity);
        return ResultVo.ok("更新成功");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询患者诊断疾病")
    public ResultVo getById(@PathVariable Integer id) {
        InpatientDisease entity = inpatientDiseaseService.getById(id);
        return ResultVo.ok(entity);
    }
    @PostMapping("/page")
    @ApiOperation("根据患者ID查询诊断疾病")
    public ResultVo queryPageByPatientId(InpatientInformationQueryDTO queryDTO) {
        IPage<DiseaseInfo> resultPage = inpatientDiseaseService.queryByPatientId(queryDTO);
        return ResultVo.ok(resultPage);
    }

}
