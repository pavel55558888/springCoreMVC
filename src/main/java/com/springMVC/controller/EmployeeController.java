package com.springMVC.controller;

import com.springMVC.dao.EmployeeDao;
import com.springMVC.entity.Employee;
import com.springMVC.service.impl.ServiceEmployeeImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private ServiceEmployeeImpl serviceEmployee;
    @GetMapping("/")
    public String mainView(Model model){
        List<Employee> allEmployees = serviceEmployee.getAllEmployees();
        model.addAttribute("allEmployee", allEmployees);

        return "main-view";
    }

    @GetMapping("/add")
    public String addEmployeeView(){
        return "add-view";
    }

    @PostMapping ("/add")
    public String addEmployee(@Valid @ModelAttribute(name = "formAdd") Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/add";
        }
        serviceEmployee.setEmployee(employee.getName(),employee.getSurname(),employee.getDepartment(),employee.getSalary(),employee.getNumber(),employee.getEmail());
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String employeeDelete(@PathVariable(value = "id") long id){
        serviceEmployee.deleteEmployee(id);
        return "redirect:/";
    }

}
