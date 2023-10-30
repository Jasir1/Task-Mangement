package com.taita.webapp.taskmanagement.controller;

import com.taita.webapp.taskmanagement.dto.RegisterTaskDTO;
import com.taita.webapp.taskmanagement.dto.UpdateRequestDTO;
import com.taita.webapp.taskmanagement.dto.UpdateTaskDTO;
import com.taita.webapp.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody RegisterTaskDTO registerTaskDTO){
        return taskService.save(registerTaskDTO);
    }

    @GetMapping("/loadTasks")
    public ResponseEntity<?> load(){
        return taskService.loadTasks();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UpdateTaskDTO updateTaskDTO){
        return taskService.update(id,updateTaskDTO);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return  taskService.delete(id);
    }
}
