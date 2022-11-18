package com.ideahub.mypay.myprojectsmypayideahub.controller;

import com.ideahub.mypay.myprojectsmypayideahub.service.OTPService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "my-pay/api/data/otps")
public class OTPController {

    private final OTPService otpService;

    public OTPController(OTPService otpService) {
        this.otpService = otpService;
    }

    @GetMapping(path = "users/{userId}")
    public ResponseEntity<?> getOTP(
            @PathVariable("userId") Long userId
    ) {
        return new ResponseEntity<>(otpService.getOTP(userId), HttpStatus.OK);
    }

    @DeleteMapping(path = "otps/{otpId}")
    public ResponseEntity<?> deleteOTP(
            @PathVariable("otpId") Long otpId
    ) {
        otpService.deleteOTP(otpId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
