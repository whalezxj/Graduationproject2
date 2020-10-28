package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.BaseModel;
import com.example.demo.pojo.Staff;
import com.example.demo.pojo.model.StaffArgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxj
 * @since 2020-09-25
 */
public interface StaffMapper extends BaseMapper<Staff> {

    @Select("select * from staff s INNER JOIN department d on s.staff_department_id = d.department_id and s.staff_name like concat('%',#{staffName},'%')")
     List<BaseModel> selectByname(@Param("staffName") String staffName);

    @Select("select * from staff s INNER JOIN department d on s.staff_department_id = d.department_id  ")
     List<BaseModel> queryBase();

    @Insert("insert into staff(staff_id,staff_name,staff_gender,staff_birthday,staff_phone,staff_department_id) value (#{staff.staffId},#{staff.staffName},#{staff.staffGender},#{staff.staffBirthday},#{staff.staffPhone},#{staff.staffDepartmentId})")
    Integer addStaff(@Param(value = "staff")StaffArgs args);

    @Update("update  staff s set s.staff_status = 1 where s.staff_id = #{id} ")
    Integer deleteStaffById(@Param("id") String id);

    @Update("update  staff s set s.staff_status = 0 where s.staff_id = #{id} ")
    Integer activiteStaffById(@Param("id") String id);

    @Select("select * from staff s where s.staff_name = #{staffName}")
    Staff getByStaffName(@Param("staffName") String staffName);

    @Insert("insert into staff(staff_id,staff_name,staff_password,staff_phone) value (#{staff.staffId},#{staff.staffName},#{staff.staffPassword},#{staff.staffPhone})")
    void registStaff(@Param(value = "staff")StaffArgs args);

    @Select("select * from staff INNER JOIN department on (staff.staff_department_id = department.department_id) where staff.staff_approval_status = '待审批' or staff.staff_approval_status = '已拒绝' or staff.staff_approval_status = '已同意' ")
    List<BaseModel> queryApply();

}
