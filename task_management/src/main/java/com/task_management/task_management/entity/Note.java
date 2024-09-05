package com.task_management.task_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "note")
public class Note {

    @EmbeddedId
    private Note_Key id;

    @ManyToOne
    @MapsId("etudiantId")  // Map the embedded id field with the entity
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @MapsId("examenId")  // Map the embedded id field with the entity
    @JoinColumn(name = "examen_id")
    private Examen examen;

    @Column(name = "valeur")
    private long valeur;
}
