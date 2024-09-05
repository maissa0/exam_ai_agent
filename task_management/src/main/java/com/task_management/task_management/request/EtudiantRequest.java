package com.task_management.task_management.request;

import lombok.Data;

@Data
public class EtudiantRequest {
    private String nom;
    private String prenom;
    private Integer ClasseId;
}
