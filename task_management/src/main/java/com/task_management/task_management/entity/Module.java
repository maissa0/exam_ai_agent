package com.task_management.task_management.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "md_id")
    private int id;

    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_md_id",referencedColumnName="md_id")
    @JsonBackReference
    private List<Examen> examens;

    @OneToMany(mappedBy = "module")
    public Set<Cl_Md_En> mds;
}
