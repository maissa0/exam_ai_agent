package com.task_management.task_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "examen")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String categorie;
    private String label;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes;

    @ManyToOne
    @JoinColumn(name = "fk_md_id")
    @JsonManagedReference
    private Module module;
}
