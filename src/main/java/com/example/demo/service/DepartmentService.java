package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.enums.deptStatus;
import com.example.demo.enums.StaffStatus;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.pojo.BaseModel;
import com.example.demo.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<BaseModel> queryAll() {
        List<BaseModel> list = departmentMapper.queryBase();
        list.forEach(item->{
            item.setStaffStatus(StaffStatus.getByValue(item.getStaffStatus()).getName());
        });
        return list;
    }

    public List<Department> queryDept() {
        List<Department> list = departmentMapper.queryDept();
        list.forEach(item->{
            item.setDepartmentStatus(deptStatus.getByValue(item.getDepartmentStatus()).getName());
        });
        return list;
    }

    @Transactional
    public Integer addDeptUser(Department department) {
        Integer insert = departmentMapper.addDeptmentUser(department);
        return insert;
    }

    @Transactional
    public Integer addDept(Department department) {
        Integer insert = departmentMapper.addDeptment(department);
        return insert;
    }

    @Transactional
    public Integer deleteDept(int id){
        Integer integer = departmentMapper.deleteById(id);
        return integer;
    }

    @Transactional
    public Integer activiteDept(int id){
        Integer integer = departmentMapper.activiteDeptById(id);
        return integer;
    }


    public List<BaseModel> selectByDepartmentName(String deptName) {
        List<BaseModel> list = departmentMapper.selectByname(deptName);
        list.forEach(item->{
            item.setStaffStatus(StaffStatus.getByValue(item.getStaffStatus()).getName());
        });
        return list;
    }

}
