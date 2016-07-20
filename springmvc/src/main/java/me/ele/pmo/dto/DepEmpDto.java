package me.ele.pmo.dto;

/**
 * Created by kimi on 6/1/16.
 */
public class DepEmpDto {
    private int departmentId;
    private String departmentName;
    private String departmentManager;
    private String projectManager;
    private int employeeId;
    private String name;
    private int age;
    private String gender;

    public DepEmpDto() {

    }

    public DepEmpDto(int departmentId, String departmentName, String departmentManager, String projectManager, int employeeId, String name, int age, String gender) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
        this.projectManager = projectManager;
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

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

    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
