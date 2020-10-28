package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author
 * @date 2020/9/25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("基础类")
public class BaseModel implements Serializable {

    /****************Dept****************/
    /**
     * 姓名  失效
     */
    @ApiModelProperty("d_name")
    private String dName;
    /**
     * 工号  失效
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


    /****************User****************/

   /* @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("username")
    private String username;
    @ApiModelProperty("password")
    private String password;
    @ApiModelProperty("mail")
    private String mail;
    @ApiModelProperty("phone")
    private String phone;
    @ApiModelProperty("gender")
    private String gender;
    @ApiModelProperty("status")
    private String status;
*/

    /***************Staff*****************/
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
