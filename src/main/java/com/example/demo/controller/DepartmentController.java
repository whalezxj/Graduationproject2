package com.example.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.pojo.BaseModel;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.model.DeptArgs;
import com.example.demo.service.DepartmentService;
import com.example.demo.utils.ExcelUtils;
import com.example.demo.utils.JSONResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@Api("部门")
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@ApiOperation("获取所有信息")
	@PostMapping("query")
	public JSONResultVo<IPage<BaseModel>> getAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 10);
		List<BaseModel> lists = departmentService.queryAll();
		PageInfo page = new PageInfo(lists, 5);
		Map<String, Object> map = new HashMap<>();
		map.put("pageInfo", page);
		JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
		return jsonResultVo.setData(map);
	}

	@ApiOperation("获取所有部门")
	@PostMapping("querydept")
	public JSONResultVo<IPage<Department>> getDepartment(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 10);
		List<Department> lists = departmentService.queryDept();
		PageInfo page = new PageInfo(lists, 5);
		Map<String, Object> map = new HashMap<>();
		map.put("pageInfo", page);
		JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
		return jsonResultVo.setData(map);
	}

	@ApiOperation("添加部门员工")
	@PostMapping("adddu")
	public JSONResultVo addDepartmentUser(@RequestBody DeptArgs args) {
		departmentService.addDeptUser(args);
		JSONResultVo jsonResultVo = new JSONResultVo();
		jsonResultVo.setInfo("添加成功");
		return jsonResultVo;
	}

	@ApiOperation("添加部门")
	@PostMapping("addddept")
	public JSONResultVo addDepartment(@RequestBody DeptArgs args) {
		departmentService.addDept(args);
		JSONResultVo jsonResultVo = new JSONResultVo();
		jsonResultVo.setInfo("添加成功");
		return jsonResultVo;
	}

	@ApiOperation("删除部门")
	@PostMapping("delete")
	public JSONResultVo deleteDepartment(@RequestParam("id") String id) {
		departmentService.deleteDept(Integer.valueOf(id));
		JSONResultVo jsonResultVo = new JSONResultVo();
		jsonResultVo.setInfo("删除成功");
		return jsonResultVo;
	}

	@ApiOperation("激活部门")
	@PostMapping("activite")
	public JSONResultVo activiteDepartment(@RequestParam("id") String id) {
		departmentService.activiteDept(Integer.valueOf(id));
		JSONResultVo jsonResultVo = new JSONResultVo();
		jsonResultVo.setInfo("激活成功");
		return jsonResultVo;
	}


	@ApiOperation("根据部门名称找员工")
	@PostMapping("select")
	public JSONResultVo<IPage> selectByDepartmentName(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam(value = "deptName") String deptName) {
		PageHelper.startPage(pn, 10);
		List<BaseModel> users = departmentService.selectByDepartmentName(deptName);
		PageInfo page = new PageInfo(users, 5);
		Map<String, Object> map = new HashMap<>();
		map.put("pageInfo", page);
		JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
		return jsonResultVo.setData(map);
	}


	@GetMapping("exportAll")
	@ApiOperation(value = "导出")
	public void exportDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<BaseModel> lists = departmentService.queryAll();
		String templateFilePath = "/excel/用户名单模板.xlsx";
		String fileName = "用户名单.xlsx";
		HashMap<String, Object> map = new HashMap<>();
		map.put("data", lists);
		ExcelUtils.export(templateFilePath, fileName, map, response);
	}
}
