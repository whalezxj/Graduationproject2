package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("请假表单")
@TableName("leaves")
public class Leave   extends BaseModel{

    private static final long serialVersionUID = 1L;

    //请假单ID
	@TableId("leave_id")
    @ApiModelProperty("leave_id")
	private Integer leaveId;

	//创建请假单时间
	@ApiModelProperty("createtime")
	private String createtime;
	//请假类型
	@ApiModelProperty("leave_type")
	private String leaveType;
	//开始时间
	@ApiModelProperty("starttime")
	private String starttime;
	//结束时间
	@ApiModelProperty("endtime")
	private String  endtime;
	//请假事由
	@ApiModelProperty("leave_reason")
	private String leaveReason;
	//请假人id
	@ApiModelProperty("leave_staff_id")
	private String leaveStaffId;
	//请假人姓名
	@ApiModelProperty("leave_staff_name")
	private String leaveStaffName;
	//审批状态
	@ApiModelProperty("leave_status")
	private String leaveStatus;
	//审批人
	@ApiModelProperty("leave_approval_admin")
	private String leaveApprovalAdmin;
	//审批时间
	@ApiModelProperty("leave_approval_date")
	private String leaveApprovalDate;
	//审批意见
	@ApiModelProperty("leave_approval_views")
	private String leaveApprovalViews;

}
