package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.pojo.BaseModel;
import com.example.demo.pojo.Leave;
import com.example.demo.pojo.Salary;
import com.example.demo.pojo.Staff;
import com.example.demo.service.LeaveService;
import com.example.demo.service.SalaryService;
import com.example.demo.service.StaffService;
import com.example.demo.utils.JSONResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2020/10/15
 **/

@RestController
@Slf4j
@Api("员工管理")
@RequestMapping("/staffmanagement")
public class StaffManagementController {

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private StaffService staffService;

    @ApiOperation("薪资管理")
    @PostMapping(value="/setsalary" )
    public JSONResultVo setSalary(@RequestBody Salary salary){
        salaryService.setSalary(salary);
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setInfo(salary);
        return jsonResultVo;
    }

    @ApiOperation("薪资列表")
    @PostMapping(value="/salarylist")
    public JSONResultVo<IPage<Salary>> querySalary(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<Salary> lists = salaryService.querySalary();
        PageInfo page = new PageInfo(lists, 5);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", page);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        return jsonResultVo.setData(map);
    }

    @ApiOperation("请假列表")
    @PostMapping(value="/leavelist")
    public JSONResultVo<IPage<Leave>> queryLeave(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<Leave> lists = leaveService.queryLeave();
        PageInfo page = new PageInfo(lists, 5);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", page);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        return jsonResultVo.setData(map);
    }


    @ApiOperation("拒绝请假")
    @PostMapping("/disagree")
    public JSONResultVo disagree(@RequestParam("id") String id) {
        leaveService.disagree(id);
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setInfo("已拒绝");
        return jsonResultVo;
    }

    @ApiOperation("同意请假")
    @PostMapping("/agree")
    public JSONResultVo agree(@RequestParam("id") String id) {
        leaveService.agree(id);
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setInfo("已同意");
        return jsonResultVo;
    }

    @ApiOperation("提交申请修改权限")
    @PostMapping("/applyrole")
    public JSONResultVo applyupdaterole(){//@RequestParam(value = "staffId") String staffId
        Subject subject = SecurityUtils.getSubject();
        Staff cur = (Staff) subject.getPrincipal();
        staffService.applyupdaterole(cur.getStaffId());
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        jsonResultVo.setMsg("提交申请成功");
        return jsonResultVo;
    }

    @ApiOperation("获取所有提交申请修改权限 待审批 已审批")
    @PostMapping("/queryapply")
    public JSONResultVo<IPage<BaseModel>> applyUpdateRole(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<BaseModel> lists = staffService.queryApply();
        PageInfo page = new PageInfo(lists, 5);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", page);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        return jsonResultVo.setData(map);
    }

    @ApiOperation("同意申请权限")
    @PostMapping("/updaterole")
    public JSONResultVo updateRole(@RequestParam(value = "staffId") String staffId){
        staffService.updateRole(staffId);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        jsonResultVo.setMsg("修改成功");
        return jsonResultVo;
    }

    @ApiOperation("拒绝申请权限")
    @PostMapping("/disagreeupdaterole")
    public JSONResultVo disAgreeUpdateRole(@RequestParam(value = "staffId") String staffId){
        staffService.disAgreeUpdateRole(staffId);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        jsonResultVo.setMsg("已拒绝");
        return jsonResultVo;
    }
}
