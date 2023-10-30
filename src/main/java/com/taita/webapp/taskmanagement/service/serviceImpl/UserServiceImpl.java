package com.taita.webapp.taskmanagement.service.serviceImpl;

import com.taita.webapp.taskmanagement.dto.RegisterDTO;
import com.taita.webapp.taskmanagement.dto.RequestMetaDTO;
import com.taita.webapp.taskmanagement.dto.UpdateRequestDTO;
import com.taita.webapp.taskmanagement.entity.User;
import com.taita.webapp.taskmanagement.repository.UserRepository;
import com.taita.webapp.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RequestMetaDTO requestMetaDTO;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> update(UpdateRequestDTO updateRequestDTO) {
        if(updateRequestDTO.getFirstName().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter first name");
        } else if(updateRequestDTO.getLastName().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter last name");
        }else if(updateRequestDTO.getMobile().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter mobile");
        }else if(updateRequestDTO.getPassword().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter password");
        }else{
            User user = userRepository.findById(requestMetaDTO.getId()).get();
                user.setFirstName(updateRequestDTO.getFirstName());
                user.setLastName(updateRequestDTO.getLastName());
                user.setPassword(updateRequestDTO.getPassword());
                user.setMobile(updateRequestDTO.getMobile());
                userRepository.save(user);
                return ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully!");
        }
    }

    @Override
    public ResponseEntity<?> delete() {
        User user = userRepository.findById(requestMetaDTO.getId()).get();
        if(user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user!");
        }
        user.setActive(false);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User deleted successfully!");
    }

    @Override
    public ResponseEntity<?> loadUsers() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
}
