/**
 *
 */
package me.ele.pmo.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author kimi
 */
@Entity
@Table(name = "tbl_department")
public class Department {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "departmentId", unique = true, nullable = false)
    private int departmentId;

    @Column(name = "departmentName")
    private String departmentName;

    @Column(name = "departmentManager")
    private String departmentManager;

    @Column(name = "projectManager")
    private String projectManager;

    public Department() {

    }

    public Department(int departmentId, String departmentName, String departmentManager, String projectManager) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
        this.projectManager = projectManager;
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

    public void show() {

    }
}
