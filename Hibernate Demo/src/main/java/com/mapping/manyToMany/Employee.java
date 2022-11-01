package com.mapping.manyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    private int eid;
    private String name;

    @ManyToMany
    @JoinTable(name = "emp_project", joinColumns = {@JoinColumn(name = "eid")}, inverseJoinColumns = {@JoinColumn(name = "pid")})
    List<Project> projectList;

    public Employee() {
    }

    public Employee(int eid, String name) {
        this.eid = eid;
        this.name = name;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
