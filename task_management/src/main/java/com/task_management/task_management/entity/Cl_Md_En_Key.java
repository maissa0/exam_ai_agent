package com.task_management.task_management.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Cl_Md_En_Key implements Serializable {
    private Integer classeId;
    private Integer moduleId;
    private Integer employeeId;

    // Default constructor
    public Cl_Md_En_Key() {
    }

    public Cl_Md_En_Key(Integer classeId, Integer moduleId, Integer employeeId) {
        this.classeId = classeId;
        this.moduleId = moduleId;
        this.employeeId = employeeId;
    }

    // Getters and setters
    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    // Override equals and hashCode for composite key comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cl_Md_En_Key that = (Cl_Md_En_Key) o;
        return Objects.equals(classeId, that.classeId) &&
                Objects.equals(moduleId, that.moduleId) &&
                Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classeId, moduleId, employeeId);
    }
}
