package me.ele.pmo.service;

import me.ele.pmo.model.Employee;
import me.ele.pmo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by kimi on 6/24/16.
 */
@Service(value = "employeeService1Impl")
public class EmployeeService1Impl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean add(Employee employee) {
        return this.employeeRepository.save(employee) != null ? true : false;
    }

    public List<Employee> query() {
        Iterable<Employee> iter = this.employeeRepository.findAll();
        final List<Employee> list = new ArrayList<Employee>();
        iter.forEach(new Consumer<Employee>() {
            public void accept(Employee employee) {
                list.add(employee);
            }
        });
        return list;
    }

    public Employee getById(int employeeId) {
        Employee employee = this.employeeRepository.findOne(employeeId);
        return employee;
    }

    public Employee getByName(String name) {
        return this.employeeRepository.getByName(name);
    }

    public Employee get(String name, String gender) {
        Employee e = this.employeeRepository.get(name, gender);
        return e;
    }
}
