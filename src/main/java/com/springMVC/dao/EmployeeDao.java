package com.springMVC.dao;

import com.springMVC.entity.Employee;
import jakarta.persistence.Column;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public void setEmployee(String name,String surname,String department,int salary,String number,String email);
    public void deleteEmployee(long id);
}
