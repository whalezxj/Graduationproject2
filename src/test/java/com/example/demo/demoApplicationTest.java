package com.example.demo;

import com.example.demo.pojo.Department;
import com.example.demo.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2020/9/9
 **/
@SpringBootTest(classes = DemoApplication.class)
public class demoApplicationTest {

    @Autowired
    DepartmentService departmentService;

    @Test
    public void getDepartment() {
        int pn = 2;
        int ps = 5;
        PageHelper.startPage(pn, ps);
        List<Department> lists = departmentService.queryDept();
        PageInfo page = new PageInfo();
//        page.setPageSize(ps);
//        page.setPageNum(pn);
        page.setList(lists);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", page);
        System.out.println(map);
    }
}
