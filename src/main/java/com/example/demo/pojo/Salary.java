package com.example.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author
 * @date 2020/10/9
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Salary extends BaseModel{

    private static final long serialVersionUID = 1L;

    //员工id
    @ApiModelProperty("salary_staff_id")
    private String salaryStaffId;
    //薪资总数
    @ApiModelProperty("salary_total")
    private Integer salaryTotal;
    //工作日数
    @ApiModelProperty("salary_work_day")
    private Integer salaryWorkDay;
    //基本工资
    @ApiModelProperty("salary_base")
    private Integer salaryBase;
    //奖金
    @ApiModelProperty("salary_bonus")
    private Integer salaryBonus;
    //交通补贴
    @ApiModelProperty("transportation_allowance")
    private Integer transportationAllowance;
    //午餐补贴
    @ApiModelProperty("lunch_allowance")
    private Integer lunchAllowance;
    //通信补贴
    @ApiModelProperty("communication_allowance")
    private Integer communicationAllowance;

}
