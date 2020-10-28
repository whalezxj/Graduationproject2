package com.example.demo.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zxj
 * @since 2020-09-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("部门")
public class Department implements Serializable {

    /**
     * 姓名
     */
    @ApiModelProperty("d_name")
    private String dName;
    /**
     * 工号
     */
    @ApiModelProperty("d_id")
    private Integer dId;
    /**
     * 部门id号
     */
    @ApiModelProperty("department_id")
    private Integer departmentId;
    /**
     * 部门名称
     */
    @ApiModelProperty("department_name")
    private String departmentName;
    /**
     * 部门主管姓名
     */
    @ApiModelProperty("department_admin")
    private String departmentAdmin;
    /**
     * 部门状态
     */
    @ApiModelProperty("department_status")
    private String departmentStatus;


}
