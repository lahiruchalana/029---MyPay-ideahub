package com.ideahub.mypay.myprojectsmypayideahub.service;

import com.ideahub.mypay.myprojectsmypayideahub.model.OTP;
import com.ideahub.mypay.myprojectsmypayideahub.model.User;
import com.ideahub.mypay.myprojectsmypayideahub.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final OTPService otpService;

    public UserService(UserRepository userRepository, OTPService otpService) {
        this.userRepository = userRepository;
        this.otpService = otpService;
    }

    public void userPhoneNumberAndEmailRegistration(Integer phoneNumber, String email) {
        Optional<User> userOptionalByPhoneNumber = userRepository.getUserByPhoneNumber(phoneNumber);
        Optional<User> userOptionalByEmail = userRepository.getUserByEmail(email);

        if (userOptionalByPhoneNumber.isPresent()) {
            throw new IllegalStateException("Existing phone number!!");
        }

        if (userOptionalByEmail.isPresent()) {
            throw new IllegalStateException("Existing email address!!");
        }

        User user = User.builder()
                .phoneNumber(phoneNumber)
                .email(email)
                .build(); // Create a user by phone number and email

        userRepository.save(user);

    }

    public void sendOTPInPhoneNumberAndEmailRegistration(Integer phoneNumber) {
        Optional<User> userOptional = userRepository.getUserByPhoneNumber(phoneNumber); // Here we get the created user for get the id of the user

        System.out.println(userOptional.get().getUserId());

        otpService.createNewOTP(userOptional.get().getUserId()); // Get OTP


        // SMS or Email sending part

    }
}
