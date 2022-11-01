package com.mapping.manyToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int pId;

    @Column(name = "project_name")
    private String projectName;

    @ManyToMany(mappedBy = "projectList")
    private List<Employee> employeeList;

    public Project() {
    }

    public Project(int pId, String projectName) {
        this.pId = pId;
        this.projectName = projectName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
