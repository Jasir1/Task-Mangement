package com.taita.webapp.taskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRequestDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String mobile;

}
