package com.taita.webapp.taskmanagement.dto;

import com.taita.webapp.taskmanagement.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskDTO {
    private String title;
    private String description;
    private LocalDate dueAt;
    private Status status;
}
