package com.taita.webapp.taskmanagement.service;

import com.taita.webapp.taskmanagement.dto.RegisterDTO;
import com.taita.webapp.taskmanagement.dto.UpdateRequestDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> update(UpdateRequestDTO updateRequestDTO);

    ResponseEntity<?> delete();

    ResponseEntity<?> loadUsers();
}
