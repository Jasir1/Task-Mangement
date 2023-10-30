package com.taita.webapp.taskmanagement.service;

import com.taita.webapp.taskmanagement.dto.LoginDTO;
import com.taita.webapp.taskmanagement.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public ResponseEntity<?> register(RegisterDTO registerDTO);

    public ResponseEntity<?> login(LoginDTO loginDTO);
}
