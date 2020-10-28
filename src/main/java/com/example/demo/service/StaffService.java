package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.enums.StaffStatus;
import com.example.demo.mapper.StaffMapper;
import com.example.demo.pojo.BaseModel;
import com.example.demo.pojo.Staff;
import com.example.demo.pojo.model.StaffArgs;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class StaffService extends ServiceImpl<StaffMapper, Staff> {

    @Autowired
    private StaffMapper staffMapper;

    public List<BaseModel> queryStaff() {
        List<BaseModel> list = staffMapper.queryBase();
        list.forEach(item -> {
            item.setStaffStatus(StaffStatus.getByValue(item.getStaffStatus()).getName());
        });
        return list;
    }


    public List<BaseModel> selectByStaffName(String staffName) {
        List<BaseModel> list = staffMapper.selectByname(staffName);
        list.forEach(item -> {
            item.setStaffStatus(StaffStatus.getByValue(item.getStaffStatus()).getName());
        });
        return list;
    }

    @Transactional
    public Integer addStaff(StaffArgs args) {
        args.setStaffId(String.valueOf(new Random().nextInt(99999)));
        Integer insert = staffMapper.insert(args);
        return insert;
    }

    @Transactional
    public void registStaff(StaffArgs args) {
        args.setStaffId(String.valueOf(new Random().nextInt(99999)));
        staffMapper.insert(args);
    }

    @Transactional
    public Integer deleteStaff(String id) {
        Integer integer = staffMapper.deleteStaffById(id);
        return integer;
    }

    @Transactional
    public Integer activiteStaff(String id) {
        Integer integer = staffMapper.activiteStaffById(id);
        return integer;
    }

    public Staff getByStaffName(String username) {
        Staff staff = staffMapper.getByStaffName(username);
        return staff;
    }

    @Transactional
    public void updateRole(String staffId) {
        Staff staff = new Staff();
        staff.setStaffId(staffId);
        staff.setStaffRole("admin");
        staff.setStaffApprovalStatus("已同意");
        staffMapper.updateById(staff);
    }

    @Transactional
    public void applyupdaterole(String staffId) {
        Staff staff = new Staff();
        staff.setStaffId(staffId);
        staff.setStaffRole("apply");
        staff.setStaffApprovalStatus("待审批");
        staffMapper.updateById(staff);
    }

    public List<BaseModel> queryApply() {
        return staffMapper.queryApply();
    }

    @Transactional
    public void updatestaff(StaffArgs args) {
        Subject subject = SecurityUtils.getSubject();
        Staff staff = (Staff) subject.getPrincipal();
        args.setStaffId(staff.getStaffId());
        staffMapper.updateById(args);
    }

    @Transactional
    public void disAgreeUpdateRole(String staffId) {
        Staff staff = new Staff();
        staff.setStaffId(staffId);
        staff.setStaffRole("staff");
        staff.setStaffApprovalStatus("已拒绝");
        staffMapper.updateById(staff);
    }

}
