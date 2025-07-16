package com.neuedu.ylbx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.ylbx.dto.DiagnosisTreatmentPageDTO;
import com.neuedu.ylbx.pojo.DiagnosisTreatment;
import com.neuedu.ylbx.service.DiagnosisTreatmentService;
import com.neuedu.ylbx.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosis-treatment")
@Api(tags = "诊疗项目管理")
public class DiagnosisTreatmentController {

    @Autowired
    private DiagnosisTreatmentService diagnosisTreatmentService;

    @PostMapping
    @ApiOperation("新增诊疗项目")
    public ResultVo add(@RequestBody DiagnosisTreatment entity) {
         diagnosisTreatmentService.save(entity);
         diagnosisTreatmentService.deleteCache();
         return ResultVo.ok("新增成功");
    }


    @ApiOperation("批量删除诊疗项目）")
    @DeleteMapping("/batch")
    public ResultVo batchDelete(@RequestParam List<Integer> ids) {
         diagnosisTreatmentService.removeByIds(ids);
        diagnosisTreatmentService.deleteCache();
        return ResultVo.ok("删除成功");
    }

    @PutMapping
    @ApiOperation("修改诊疗项目")
    public ResultVo update(@RequestBody DiagnosisTreatment entity) {
         diagnosisTreatmentService.updateById(entity);
        diagnosisTreatmentService.deleteCache();
         return ResultVo.ok("修改成功");
    }

    @PostMapping("/page")
    @ApiOperation("分页查询诊疗项目")
    public ResultVo getPage(@RequestBody DiagnosisTreatmentPageDTO dto) {
        Page<DiagnosisTreatment> diagnosisTreatmentPage= diagnosisTreatmentService.getPage(dto);
        return ResultVo.ok(diagnosisTreatmentPage);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询诊疗项目")
    public ResultVo getById(@PathVariable Integer id) {
        DiagnosisTreatment item = diagnosisTreatmentService.getById(id);
        if (item == null) {
            return ResultVo.fail("未找到内容");
        }
        return ResultVo.ok(item);
    }

}