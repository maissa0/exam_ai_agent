package com.task_management.task_management.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cl_md_en")
public class Cl_Md_En {

    @EmbeddedId
    private Cl_Md_En_Key id;

    @ManyToOne
    @MapsId("classeId")  // This is to map the embedded id field with the entity
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @ManyToOne
    @MapsId("moduleId")  // This is to map the embedded id field with the entity
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne
    @MapsId("employeeId")  // This is to map the embedded id field with the entity
    @JoinColumn(name = "employee_id")
    private Employee employee;
}

