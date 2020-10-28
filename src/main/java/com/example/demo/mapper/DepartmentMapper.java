package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.BaseModel;
import com.example.demo.pojo.Department;
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
public interface DepartmentMapper extends BaseMapper<Department> {

    @Select("select d.* from department d")
     List<Department> getList();

    @Select("select * from department d INNER JOIN user u on d.d_id=u.id and d.department_name like concat('%',#{departmentName},'%')")
     List<BaseModel> selectByname(@Param("departmentName") String departmentName);

    @Select("select * from department d INNER JOIN user u on d.department_id = u.department_id  ")
     List<BaseModel> queryBase();

    @Select("select * from department d")
    List<Department> queryDept();

    @Insert("insert into department(d_id,d_name,department_id,department_name,department_admin) value (#{department.dId},#{department.dName},#{department.departmentId},#{department.departmentName},#{department.departmentAdmin})")
     Integer addDeptmentUser(@Param(value = "department") Department department);


    @Update("update  department d  set d.department_status = 1 where d.department_id = #{id} ")
    Integer deleteById(@Param("id") Integer id);

    @Update("update  department d  set d.department_status = 0 where d.department_id = #{id} ")
    Integer activiteDeptById(@Param("id") Integer id);



    @Insert("insert into department(department_name,department_admin) value (#{department.departmentName},#{department.departmentAdmin})")
     Integer addDeptment(@Param(value = "department") Department department);
}
