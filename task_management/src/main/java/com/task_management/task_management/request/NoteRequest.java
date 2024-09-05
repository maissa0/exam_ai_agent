package com.task_management.task_management.request;

import lombok.Data;

@Data
public class NoteRequest {

    private Integer etudiantId;
    private Integer examenId;
    private Long valeur;
}
