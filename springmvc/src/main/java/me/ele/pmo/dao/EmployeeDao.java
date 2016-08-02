package me.ele.pmo.dao;

import me.ele.pmo.model.Employee;

import java.util.List;

/**
 * Created by kimi on 5/17/16.
 */
public interface EmployeeDao {
    boolean add(Employee employee);

    List<Employee> query();

    Employee getById(int employeeId);
}
