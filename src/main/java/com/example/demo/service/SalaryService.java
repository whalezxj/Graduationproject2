package com.example.demo.service;

import com.example.demo.enums.StaffStatus;
import com.example.demo.mapper.SalaryMapper;
import com.example.demo.pojo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2020/10/9
 **/
@Service
public class SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    public Salary getSalary(String staffId) {
        Salary salary = salaryMapper.getSalary(staffId);
        return salary;
    }

    public List<Salary> querySalary() {
        List<Salary> list = salaryMapper.querySalary();
        list.forEach(item->{
            item.setStaffStatus(StaffStatus.getByValue(item.getStaffStatus()).getName());
        });
        return list;
    }

    public void setSalary(Salary salary) {
        salary.setSalaryTotal((salary.getSalaryBase()/22)*salary.getSalaryWorkDay()+salary.getSalaryBonus()+salary.getCommunicationAllowance()+salary.getLunchAllowance()+salary.getTransportationAllowance());
        salaryMapper.setSalary(salary);
    }
}
