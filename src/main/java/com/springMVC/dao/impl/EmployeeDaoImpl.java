package com.springMVC.dao.impl;

import com.springMVC.dao.EmployeeDao;
import com.springMVC.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees;
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();
            allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
            session.getTransaction().commit();
        }
        return allEmployees;
    }

    @Override
    public void setEmployee(String name, String surname, String department, int salary, String number, String email) {
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();
            session.persist(new Employee(name, surname, department, salary, number, email));
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteEmployee(long id) {
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();
            session.createQuery("delete Employee where id = :param1")
                    .setParameter("param1",id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }
}
