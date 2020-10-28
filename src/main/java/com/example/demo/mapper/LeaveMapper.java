package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Leave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LeaveMapper  extends BaseMapper<Leave> {


    @Insert("insert into leaves  (leave_id, leave_type, starttime,endtime, leave_reason, leave_staff_id,leave_staff_name, leave_status, createtime )" +
            " values (#{leave.leaveId}, #{leave.leaveType}, #{leave.starttime},#{leave.endtime}, #{leave.leaveReason}, #{leave.leaveStaffId},#{leave.leaveStaffName}, #{leave.leaveStatus}, #{leave.createtime})")
    void addLeave(@Param("leave") Leave leave);

    @Select("select * from leaves")
    List<Leave> queryLeave();


    @Select("select *  from leaves where leave_staff_id = #{staffId}")
    List<Leave> getLeave(@Param("staffId") String staffId);

    @Update("update  leaves  set leaves.leave_status = '请假失败' where leaves.leave_id = #{id} ")
    void disagree(@Param("id") Integer id);

    @Update("update  leaves  set leaves.leave_status = '请假成功' where leaves.leave_id = #{id} ")
    void agree(@Param("id") Integer id);

}
