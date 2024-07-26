package com.springMVC.service.impl;

import com.springMVC.dao.EmployeeDao;
import com.springMVC.entity.Employee;
import com.springMVC.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ServiceEmployeeImpl implements ServiceEmployee {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public void setEmployee(String name, String surname, String department, int salary, String number, String email) {
        employeeDao.setEmployee(name, surname, department, salary, number, email);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeDao.deleteEmployee(id);
    }
}
