package com.ideahub.mypay.myprojectsmypayideahub.controller;

import com.ideahub.mypay.myprojectsmypayideahub.model.User;
import com.ideahub.mypay.myprojectsmypayideahub.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "my-pay/api/data/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "email-and-phone-number-registration")
    public ResponseEntity<?> userPhoneNumberAndEmailRegistration(
            @RequestBody User user
    ) {
        userService.userPhoneNumberAndEmailRegistration(user.getPhoneNumber(), user.getEmail());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "phone-numbers/{phoneNumber}/send-otp")
    public ResponseEntity<?> sendOTPInPhoneNumberAndEmailRegistration(
            @PathVariable("phoneNumber") Integer phoneNumber
    ) {
        userService.sendOTPInPhoneNumberAndEmailRegistration(phoneNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
