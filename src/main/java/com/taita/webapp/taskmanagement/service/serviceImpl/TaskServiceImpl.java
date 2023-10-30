package com.taita.webapp.taskmanagement.service.serviceImpl;

import com.taita.webapp.taskmanagement.dto.RegisterTaskDTO;
import com.taita.webapp.taskmanagement.dto.RequestMetaDTO;
import com.taita.webapp.taskmanagement.dto.UpdateTaskDTO;
import com.taita.webapp.taskmanagement.entity.Task;
import com.taita.webapp.taskmanagement.entity.User;
import com.taita.webapp.taskmanagement.repository.TaskRepository;
import com.taita.webapp.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    RequestMetaDTO requestMetaDTO;
    @Override
    public ResponseEntity<?> save(RegisterTaskDTO registerTaskDTO) {
        if(registerTaskDTO.getTitle().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter title");
        } else if(registerTaskDTO.getDescription().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter description");
        } else if(registerTaskDTO.getDueAt().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter due date");
        }else{
            Task task = new Task();
            task.setTitle(registerTaskDTO.getTitle());
            task.setDescription(registerTaskDTO.getDescription());
            task.setDueAt(registerTaskDTO.getDueAt());
            task.setCreatedBy(requestMetaDTO.getId());

            taskRepository.save(task);
            return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully!");
        }
    }

    @Override
    public ResponseEntity<?> loadTasks(){
        List<Task> allTasks = taskRepository.findAllByActive(true);
        return ResponseEntity.status(HttpStatus.OK).body(allTasks);
    }

    @Override
    public ResponseEntity<?> update(Long id, UpdateTaskDTO updateTaskDTO) {
        if(updateTaskDTO.getTitle().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter title");
        } else if(updateTaskDTO.getDescription().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter description");
        } else if(updateTaskDTO.getDueAt().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter due date");
        } else if(updateTaskDTO.getStatus().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please select status");
        }else{
            Task task = taskRepository.findById(id).get();
            task.setTitle(updateTaskDTO.getTitle());
            task.setDescription(updateTaskDTO.getDescription());
            task.setDueAt(updateTaskDTO.getDueAt());
            task.setStatus(updateTaskDTO.getStatus());
            task.setCreatedBy(requestMetaDTO.getId());

            taskRepository.save(task);
            return ResponseEntity.status(HttpStatus.CREATED).body("Task updated successfully!");
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id){
        Task task = taskRepository.findById(id).get();
        if(task == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid task!");
        }
        task.setActive(false);
        taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("task deleted successfully!");
    }
}
