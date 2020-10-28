package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Salary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SalaryMapper extends BaseMapper<Salary> {

    @Select("select * from salary where salary.salary_staff_id = #{staffId}")
    Salary getSalary(@Param("staffId") String staffId);

    @Select("select * from (salary s INNER JOIN staff on s.salary_staff_id = staff.staff_id) inner join department on staff.staff_department_id = department.department_id ")
    List<Salary> querySalary();

    @Insert("insert into salary s (s.salary_staff_id,s.salary_total,s.salary_work_day,s.salary_base,s.salary_bonus) values( #{salary.salaryStaffId},#{salary.salaryTotal},#{salary.salaryWorkDay},#{salary.salaryBase},#{salary.salaryBonus})")
    void setSalary(@Param("salary") Salary salary);
}
