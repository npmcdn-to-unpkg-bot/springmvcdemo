package me.ele.pmo.service;

import me.ele.pmo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by kimi on 7/12/16.
 */
@Service(value = "employeeService2Impl")
public class EmployeeService2Impl implements EmployeeService {

    @Autowired
    private CrudRepository<Employee, Integer> employeeCrudRepository;

    public boolean add(Employee employee) {
        return this.employeeCrudRepository.save(employee) != null;
    }

    public List<Employee> query() {
        final List<Employee> list = new ArrayList<Employee>();
        Iterable<Employee> iterable = this.employeeCrudRepository.findAll();
        iterable.forEach(new Consumer<Employee>() {
            public void accept(Employee employee) {
                list.add(employee);
            }
        });
        return list;
    }

    public Employee getById(int employeeId) {
        return this.employeeCrudRepository.findOne(employeeId);
    }

    public Employee getByName(final String name) {
        List<Integer> iterable = new ArrayList<Integer>();
        iterable.add(1);
        iterable.add(2);
        iterable.add(3);
        iterable.add(4);
        iterable.add(5);
        Iterable<Employee> employees = this.employeeCrudRepository.findAll(iterable);
        final Employee result = new Employee();
        employees.forEach(new Consumer<Employee>() {
            public void accept(Employee employee) {
                if (name.equals(employee.getName())) {
                    result.setAge(employee.getAge());
                    result.setDepartment(employee.getDepartment());
                    result.setEmployeeId(employee.getEmployeeId());
                    result.setGender(employee.getGender());
                    result.setName(employee.getName());
                }
            }
        });

        return result;
    }

    public Employee get(final String name, final String gender) {
        List<Integer> iterable = new ArrayList<Integer>();
        iterable.add(1);
        iterable.add(2);
        iterable.add(3);
        iterable.add(4);
        iterable.add(5);
        Iterable<Employee> employees = this.employeeCrudRepository.findAll(iterable);
        final Employee result = new Employee();
        employees.forEach(new Consumer<Employee>() {
            public void accept(Employee employee) {
                if (name.equals(employee.getName()) && gender.equals(employee.getGender())) {
                    result.setAge(employee.getAge());
                    result.setDepartment(employee.getDepartment());
                    result.setEmployeeId(employee.getEmployeeId());
                    result.setGender(employee.getGender());
                    result.setName(employee.getName());
                }
            }
        });

        return result;
    }
}
