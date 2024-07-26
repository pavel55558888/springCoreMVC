package com.springMVC.service;

import com.springMVC.entity.Employee;

import java.util.List;

public interface ServiceEmployee {
    public List<Employee> getAllEmployees();
    public void setEmployee(String name,String surname,String department,int salary,String number,String email);
    public void deleteEmployee(long id);
}
