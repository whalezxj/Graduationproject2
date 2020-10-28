package com.example.demo.service;

import com.example.demo.mapper.LeaveMapper;
import com.example.demo.pojo.Leave;
import com.example.demo.pojo.Staff;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author
 * @date 2020/10/9
 **/
@Service
public class LeaveService  {

    @Autowired
    private LeaveMapper leaveMapper;

    public String addLeave(Leave leave) {
        Subject subject = SecurityUtils.getSubject();
        Staff principal = (Staff) subject.getPrincipal();
        leave.setLeaveStaffId(principal.getStaffId());
        leave.setLeaveStaffName(principal.getStaffName());
        leave.setLeaveStatus("待审批");
        leave.setLeaveId(new Random().nextInt(999999));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = format.format(date);
        leave.setCreatetime(dateString);
        leaveMapper.insert(leave);
        return "提交成功";
    }

    public List<Leave> queryLeave() {
        List<Leave> list = leaveMapper.queryLeave();
        return list;
    }


    public List<Leave> getLeave(String staffId) {
        List<Leave> list = leaveMapper.getLeave(staffId);
        return list;
    }

    public void disagree(String id) {
        Subject subject = SecurityUtils.getSubject();
        Staff cur = (Staff) subject.getPrincipal();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s = format.format(date);
        Integer value = Integer.valueOf(id);
        Leave leave = new Leave();
        leave.setLeaveId(value);
        leave.setLeaveStatus("请假失败");
        leave.setLeaveApprovalAdmin(cur.getStaffName());
        leave.setLeaveApprovalDate(s);
        leaveMapper.updateById(leave);
    }

    public void agree(String id) {
        Subject subject = SecurityUtils.getSubject();
        Staff cur = (Staff) subject.getPrincipal();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s = format.format(date);
        Integer value = Integer.valueOf(id);
        Leave leave = new Leave();
        leave.setLeaveId(value);
        leave.setLeaveStatus("请假成功");
        leave.setLeaveApprovalAdmin(cur.getStaffName());
        leave.setLeaveApprovalDate(s);
        leaveMapper.updateById(leave);
    }
}
