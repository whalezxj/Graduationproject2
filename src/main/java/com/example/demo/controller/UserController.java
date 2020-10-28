package com.example.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Args;
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

/**
 * @author RegisterController
 * @date 2020/8/26
 **/

@Slf4j
@RestController
@Api("UserController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
/*
    @ApiOperation("/登录")
    @RequestMapping(value = "/login")
    public String submitLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        User user = userService.getByUserName(username);
        session.setAttribute("user", user);
        if ("用户不存在".equals(userService.submitLogin(user))) {
            return "index";
        }
        return "home";
    }

    @ApiOperation("注册")
    @PostMapping(value = "/submit")
    @ResponseBody
    public JSONResultVo regist(@RequestBody Args registArgs) {
        userService.registUser(registArgs);
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setMsg("注册成功");
        return jsonResultVo;
    }*/

    @ApiOperation("根据Id获取")
    @GetMapping(value = "/get")
    public JSONResultVo getUserInfo(@RequestParam("id") int id) {
        User user = userService.getById(id);
        return JSONResultVo.setData(user.toString());
    }

    @ApiOperation("保存更新")
    @PostMapping(value = "/save")
    public JSONResultVo saveOrUpdate(@RequestBody Args registArgs) {
        userService.saveOrUpdate(registArgs);
        JSONResultVo jsonResultVo = new JSONResultVo();
        jsonResultVo.setMsg("修改成功");
        return jsonResultVo;
    }


    @ApiOperation("删除")
    @PostMapping("delete")
    public String delete(@RequestParam("id") String id) {
        userService.deleteById(Integer.valueOf(id));
        return "删除成功";
    }

    @ApiOperation("激活")
    @PostMapping("activite")
    public String activite(@RequestParam("id") String id) {
        userService.activiteById(Integer.valueOf(id));
        return "激活成功";
    }

    @ApiOperation("分页查询")
    @PostMapping("queryPage")
    public JSONResultVo<IPage<User>> queryPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<User> list = userService.queryPage();
        PageInfo page = new PageInfo(list, 5);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", page);
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        return jsonResultVo.setData(map);
    }


    @GetMapping("exportAll")
    @ApiOperation(value = "导出")
    public void exportDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> list = userService.queryPage();
        String templateFilePath = "/excel/用户名单模板.xlsx";
        String fileName = "用户名单.xlsx";
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", list);
        ExcelUtils.export(templateFilePath, fileName, map, response);
    }
}
