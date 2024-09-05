package com.task_management.task_management.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="specialite")
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="spec_id")
    private int id;

    private String label;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_sp_id",referencedColumnName="spec_id")
    @JsonBackReference
    private List<Classe> classes;


}
