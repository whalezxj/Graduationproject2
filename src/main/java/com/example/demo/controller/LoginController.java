package com.example.demo.controller;

import com.example.demo.pojo.Staff;
import com.example.demo.pojo.model.LoginArgs;
import com.example.demo.pojo.model.StaffArgs;
import com.example.demo.service.StaffService;
import com.example.demo.utils.JSONResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/9/26
 **/
@Slf4j
@RestController
@Api("LoginController")
public class LoginController {
    @Autowired
    private StaffService staffService;

    @ApiOperation("/权限登录")
    @PostMapping(value = "/user/login")
    public JSONResultVo submitLogin(Model model, @RequestBody LoginArgs args) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录数据
        UsernamePasswordToken token =new UsernamePasswordToken(args.getUsername(),args.getPassword());
        JSONResultVo<Object> jsonResultVo = new JSONResultVo<>();
        try{
            subject.login(token);
            jsonResultVo.setInfo("登录成功");
            return jsonResultVo;
        }catch (UnknownAccountException e){//用户名不存在
            jsonResultVo.setInfo("用户不存在");
            return jsonResultVo;
        }catch (IncorrectCredentialsException e) {
            jsonResultVo.setInfo("密码错误");
            return jsonResultVo;
        }
    }
    @ApiOperation("添加员工")
    @PostMapping("/regist")
    public JSONResultVo addStaff(@RequestBody StaffArgs args) {
        JSONResultVo jsonResultVo = new JSONResultVo();
        Staff staff = staffService.getByStaffName(args.getStaffName());
        if (null!=staff){
            jsonResultVo.setMsg("名字太受欢迎了，换一个哦");
            return jsonResultVo;
        }
        staffService.registStaff(args);
        jsonResultVo.setMsg("添加成功");
        return jsonResultVo;
    }
}
