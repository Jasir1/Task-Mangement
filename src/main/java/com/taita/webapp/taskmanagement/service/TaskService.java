package com.taita.webapp.taskmanagement.service;

import com.taita.webapp.taskmanagement.dto.RegisterTaskDTO;
import com.taita.webapp.taskmanagement.dto.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;

public interface TaskService{
    ResponseEntity<?> save(RegisterTaskDTO registerTaskDTO);

    ResponseEntity<?> loadTasks();

    ResponseEntity<?> update(Long id,UpdateTaskDTO updateTaskDTO);

    ResponseEntity<?> delete(Long id);
}
