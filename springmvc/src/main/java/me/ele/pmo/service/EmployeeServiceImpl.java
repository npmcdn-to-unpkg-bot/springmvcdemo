package me.ele.pmo.service;

import me.ele.pmo.dao.EmployeeDao;
import me.ele.pmo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kimi on 5/17/16.
 */
@Service(value = "employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDaoImpl;

    public boolean add(Employee employee) {
        return this.employeeDaoImpl.add(employee);
    }

    public List<Employee> query() {
        return this.employeeDaoImpl.query();
    }

    public Employee getById(int employeeId) {
        return this.employeeDaoImpl.getById(employeeId);
    }

    public Employee getByName(String name) {
        return new Employee();
    }

    public Employee get(String name, String gender) {
        return new Employee();
    }

    public Employee get(String name, int age) {
        return new Employee();
    }
}
