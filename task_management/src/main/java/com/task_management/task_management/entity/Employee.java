package com.task_management.task_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String numero;


    @OneToMany(mappedBy = "employee")
    public Set<Cl_Md_En> ens;

}
