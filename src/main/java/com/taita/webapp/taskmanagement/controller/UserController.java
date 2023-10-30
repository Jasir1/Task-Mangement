package com.taita.webapp.taskmanagement.controller;

import com.taita.webapp.taskmanagement.dto.RegisterDTO;
import com.taita.webapp.taskmanagement.dto.UpdateRequestDTO;
import com.taita.webapp.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/loadUsers")
    public ResponseEntity<?> load(){
        return userService.loadUsers();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateRequestDTO updateRequestDTO){
        return userService.update(updateRequestDTO);
    }

    @PutMapping("/delete")
    public ResponseEntity<?> delete(){
        return  userService.delete();
    }

}
