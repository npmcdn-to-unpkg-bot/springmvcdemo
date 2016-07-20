package me.ele.pmo.model;

/**
 * Created by kimi on 5/23/16.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_project")
public class Project {

    @Id
    private int projectId;

    @Column(name = "departmentId")
    private int departmentId;

    @Column(name = "departmentName")
    private String departmentName;

    public Project() {

    }

    public Project(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    @Override
    public String toString() {
        return String.format(
                "Project[projectId=%d, departmentId='%d', departmentName='%s']",
                projectId, departmentId, departmentName);
    }
}
