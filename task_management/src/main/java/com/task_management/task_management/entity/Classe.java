package com.task_management.task_management.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "classe_id")
    private int id;

    private String name;

    @OneToMany(mappedBy = "classe")
    public Set<Cl_Md_En> cls;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_cl_id",referencedColumnName="classe_id")
    @JsonBackReference
    private List<Etudiant> etudiants;


    @ManyToOne
    @JoinColumn(name = "fk_sp_id")
    @JsonManagedReference
    private Specialite specialite;

    @ManyToOne
    @JoinColumn(name = "fk_an_id")
    @JsonManagedReference
    private Annee_scolaire anneeScolaire;
}
