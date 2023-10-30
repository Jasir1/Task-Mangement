package com.taita.webapp.taskmanagement.dto;

import com.taita.webapp.taskmanagement.entity.Status;
import com.taita.webapp.taskmanagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterTaskDTO {
    private String title;
    private String description;
    private LocalDate dueAt;
}
