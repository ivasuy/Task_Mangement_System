package com.vasu.task.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "tasks"
)
public class TaskEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    private String description;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String updatedDate;
}
