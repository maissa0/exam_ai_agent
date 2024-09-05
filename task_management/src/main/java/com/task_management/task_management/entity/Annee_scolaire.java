package com.task_management.task_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="annee_scolaire")
public class Annee_scolaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "annee_id")
    private int id;

    // Start year of the academic year
    private int startYear;

    // End year of the academic year (automatically calculated as startYear + 1)
    private int endYear;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_an_id",referencedColumnName="annee_id")
    @JsonBackReference
    private List<Classe> classes;


    // Custom setter for startYear to automatically set endYear
    public void setStartYear(int startYear) {
        this.startYear = startYear;
        this.endYear = startYear + 1;
    }

    // A method to get the academic year as a formatted string
    public String getFormattedAnnee() {
        return startYear + "/" + endYear;
    }
}
