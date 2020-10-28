package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author
 * @date 2020/9/11
 **/
@Controller
public class UtilController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/userslist")
    public String userslist(){
        return "userslist";
    }
    @GetMapping("/userslist/adduser")
    public String adduser(){
        return "adduser";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/index")
    public String index(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "index";
    }
    @GetMapping("/deptlist")
    public String deptlist(){
        return "deptlist";
    }
    @GetMapping("/stafflist")
    public String stafflist(){
        return "stafflist";
    }
    @GetMapping("/mysalary")
    public String mysalary(){
        return "mysalary";
    }
    @GetMapping("/operationleave")
    public String operationleave(){
        return "operationleave";
    }
    @GetMapping("/roleapproval")
    public String roleapproval(){
        return "roleapproval";
    }
    @GetMapping("/salarylist")
    public String salarylist(){
        return "salarylist";
    }
    @GetMapping("/leave")
    public String leave(){
        return "leave";
    }

    @RequestMapping("/noauth")
    public String unauthorized(){
        return "noauth";
    }
    @RequestMapping("/currentuser")
    public String currentuser(){
        return "currentuser";
    }

}
