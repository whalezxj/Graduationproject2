package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.pojo.BaseModel;
import com.example.demo.pojo.model.StaffArgs;
import com.example.demo.service.StaffService;
import com.example.demo.utils.JSONResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2020/9/29
 **/
@RestController
@RequestMapping("staff")
@Api("员工信息")
public class StaffController {


    @Autowired
    private StaffService staffService;

    @ApiOperation("获取所有员工所有信息")
    @PostMapping("query")
    public JSONResultVo<IPage<BaseModel>> queryStaff(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<BaseModel> lists = staffService.queryStaff();
        PageInfo page = new PageInfo(lists, 5);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", page);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        return jsonResultVo.setData(map);
    }


    @ApiOperation("添加员工")
    @PostMapping("addstaff")
    public JSONResultVo addStaff(@RequestBody StaffArgs args) {
        staffService.addStaff(args);
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setInfo("添加成功");
        return jsonResultVo;
    }

    @ApiOperation("修改员工个人信息")
    @PostMapping("updatestaff")
    public JSONResultVo updatestaff(@RequestBody StaffArgs args) {
        staffService.updatestaff(args);
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setInfo("修改成功");
        return jsonResultVo;
    }

    @ApiOperation("删除员工")
    @PostMapping("deletestaff")
    public JSONResultVo deleteStaff(@RequestParam("id") String id) {
        staffService.deleteStaff(id);
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setInfo("删除成功");
        return jsonResultVo;
    }

    @ApiOperation("激活员工")
    @PostMapping("activite")
    public JSONResultVo activiteStaff(@RequestParam("id") String id) {
        staffService.activiteStaff(id);
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setInfo("激活成功");
        return jsonResultVo;
    }

    @ApiOperation("根据姓名找员工")
    @PostMapping("select")
    public JSONResultVo<IPage<BaseModel>> selectByStaffName(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam(value = "staffName") String staffName) {
        PageHelper.startPage(pn, 10);
        List<BaseModel> staff = staffService.selectByStaffName(staffName);
        PageInfo page = new PageInfo(staff, 5);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", page);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        return jsonResultVo.setData(map);
    }

}
