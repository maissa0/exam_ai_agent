package com.task_management.task_management.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "fk_cl_id")
    @JsonManagedReference
    private Classe classe;


    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    public Set<Note> notes;
}
