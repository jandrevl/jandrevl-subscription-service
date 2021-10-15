package com.ironhack.subscriptionservice.dto;

import com.ironhack.subscriptionservice.enums.Status;
import com.ironhack.subscriptionservice.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private UserType userType;

    private Status status;

    private LocalDate joinedTheGymSince;

}

