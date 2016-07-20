package me.ele.pmo.model;

import java.util.List;

/**
 * Created by kimi on 5/28/16.
 */
public class Dep {
    private int departmentId;
    private String departmentName;
    private List<Emp> employees;
    
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Emp> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Emp> employees) {
        this.employees = employees;
    }
}
