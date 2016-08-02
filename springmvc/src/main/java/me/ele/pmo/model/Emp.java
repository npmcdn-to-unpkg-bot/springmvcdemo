package me.ele.pmo.model;

/**
 * Created by kimi on 5/28/16.
 */
public class Emp {
    private int employeeId;
    private String name;
    private int age;
    private String gender;

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

    @Override
    public String toString() {
        return this.employeeId + " " + this.name + " " + this.age + " " + this.gender;
    }

    public void Console() {
        this.toString();
    }
}
