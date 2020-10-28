package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author zxj
 * @since 2020-09-29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Staff")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工号
     */
    @ApiModelProperty("staff_id")
    @TableId("staff_id")
    private String staffId;
    /**
     * 员工姓名
     */
    @ApiModelProperty("staff_name")
    private String staffName;
    /**
     * 部门号
     */
    @ApiModelProperty("staff_department_id")
    private Integer staffDepartmentId;
    /**
     * 薪水
     */
    @ApiModelProperty("sraff_salary")
    private BigDecimal staffSalary;
    /**
     * 员工状态
     */
    @ApiModelProperty("sraff_status")
    private String staffStatus;
    /**
     * 员工性别
     */
    @ApiModelProperty("staff_gender")
    private String staffGender;
    /**
     * 员工生日
     */
    @ApiModelProperty("staff_birthday")
    private String staffBirthday;
    /**
     * 员工手机号
     */
    @ApiModelProperty("staff_phone")
    private String staffPhone;
    /**
     * 员工权限
     */
    @ApiModelProperty("staff_role")
    private String staffRole;
    /**
     * 员工登录密码
     */
    @ApiModelProperty("staff_password")
    private String staffPassword;
    /**
     * 权限审批状态
     */
    @ApiModelProperty("staff_approval_status")
    private String staffApprovalStatus;

}
