package com.task_management.task_management.request;


import lombok.Data;

import java.util.Date;

@Data
public class ExamenRequest {
    private String categorie;
    private String Label;
    private Date date;
    private Integer moduleId;

}
