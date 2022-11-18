package com.ideahub.mypay.myprojectsmypayideahub.controller;

import com.ideahub.mypay.myprojectsmypayideahub.model.User;
import com.ideahub.mypay.myprojectsmypayideahub.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "my-pay/api/data/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "registration")
    public ResponseEntity<?> userPhoneNumberAndEmailRegistration(
            @RequestBody User user
    ) {
        userService.userPhoneNumberAndEmailRegistration(user.getPhoneNumber(), user.getEmail());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
