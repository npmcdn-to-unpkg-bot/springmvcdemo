package me.ele.pmo.service;

import me.ele.pmo.model.Employee;

import java.util.List;

/**
 * Created by kimi on 5/17/16.
 */
public interface EmployeeService {
    boolean add(Employee employee);

    List<Employee> query();

    Employee getById(int employeeId);

    Employee getByName(String name);

    Employee get(String name, String gender);
}
