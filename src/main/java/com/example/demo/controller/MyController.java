package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.pojo.Leave;
import com.example.demo.pojo.Salary;
import com.example.demo.pojo.Staff;
import com.example.demo.service.LeaveService;
import com.example.demo.service.SalaryService;
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
 * @date 2020/10/9
 **/

@RestController
@Slf4j
@Api("我的")
@RequestMapping("/my")
public class MyController {

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private SalaryService salaryService;

    @ApiOperation("当前用户薪资")
    @PostMapping(value = "/salary")
    public JSONResultVo getSalary() {
        Subject subject = SecurityUtils.getSubject();
        Staff staff = (Staff) subject.getPrincipal();
        Salary salary = salaryService.getSalary(staff.getStaffId());
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setInfo(salary);
        return jsonResultVo;
    }

    @ApiOperation("当前登录用户信息")
    @PostMapping(value = "/idea")
    public JSONResultVo getStaff() {
        Subject subject = SecurityUtils.getSubject();
        Staff staff = (Staff) subject.getPrincipal();
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setInfo(staff);
        return jsonResultVo;
    }


    @ApiOperation("请假")
    @PostMapping(value = "/addleave")
    public JSONResultVo addLeave(@RequestBody Leave leave){
        String result = leaveService.addLeave(leave);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        jsonResultVo.setInfo(result);
        return jsonResultVo;
    }

    @ApiOperation("获取当前用户请假列表")
    @PostMapping(value = "/getleave")
    public JSONResultVo<IPage<Leave>> getLeave(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        Subject subject = SecurityUtils.getSubject();
        Staff staff = (Staff) subject.getPrincipal();
        String staffId = staff.getStaffId();
        List<Leave> lists = leaveService.getLeave(staffId);
        PageInfo page = new PageInfo(lists, 5);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", page);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        return jsonResultVo.setData(map);
    }
}

