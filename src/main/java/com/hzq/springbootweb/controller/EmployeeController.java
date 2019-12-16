package com.hzq.springbootweb.controller;

import com.hzq.springbootweb.dao.DepartmentDao;
import com.hzq.springbootweb.dao.EmployeeDao;
import com.hzq.springbootweb.entities.Department;
import com.hzq.springbootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @version 1.0
 * @date 2019-12-09 14:42
 **/
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    /**
     * 查询所有员工返回列表页面
     * @return 返回员工列表页面
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     *
     * @return 添加页面
     */
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        //来到添加页面,查出所有的部门,在页面显示
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }


    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee=employeeDao.get(id);
        model.addAttribute("emp",employee);
        //来到修改页面,查出所有的部门,在页面显示
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面
        return "emp/add";
    }

    /**
     * 员工修改
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工的数据"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
