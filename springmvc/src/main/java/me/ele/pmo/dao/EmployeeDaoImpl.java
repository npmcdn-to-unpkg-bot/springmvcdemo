package me.ele.pmo.dao;

import me.ele.pmo.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kimi on 5/17/16.
 */
@Repository(value = "employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean add(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        Serializable id = session.getIdentifier(employee);
        session.flush();
        session.close();
        return id != null ? true : false;
    }

    public List<Employee> query() {
        return sessionFactory.openSession().createQuery("from Employee").list();
    }

    public Employee getById(int employeeId) {
        return (Employee) sessionFactory.openSession().get(Employee.class, employeeId);
    }
}
