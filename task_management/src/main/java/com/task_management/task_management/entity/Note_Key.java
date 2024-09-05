package com.task_management.task_management.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Note_Key implements Serializable {
    private Integer etudiantId;
    private Integer examenId;

    // Default constructor
    public Note_Key() {}

    // Parameterized constructor
    public Note_Key(Integer etudiantId, Integer examenId) {
        this.etudiantId = etudiantId;
        this.examenId = examenId;
    }

    // Getters and Setters
    public Integer getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Integer etudiantId) {
        this.etudiantId = etudiantId;
    }

    public Integer getExamenId() {
        return examenId;
    }

    public void setExamenId(Integer examenId) {
        this.examenId = examenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note_Key noteKey = (Note_Key) o;
        return etudiantId.equals(noteKey.etudiantId) && examenId.equals(noteKey.examenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etudiantId, examenId);
    }
}
