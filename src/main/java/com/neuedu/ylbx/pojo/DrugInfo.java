package com.neuedu.ylbx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;

@Data
@ApiModel("药品基本信息")
@TableName("drug_info")
public class DrugInfo {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("分类")
    private String insuranceType;

    @ApiModelProperty("药品中文名称")
    private String chinaName;

    @ApiModelProperty("商品名")
    private String goodsName;

    @ApiModelProperty("规格")
    private String specifications;

    @ApiModelProperty("单位")
    private String drugUnit;

    @ApiModelProperty("生产企业")
    private String drugManufacturer;

    @ApiModelProperty("价格")
    private BigDecimal drugPrice;

    @ApiModelProperty("备注")
    private String remarks;
}
