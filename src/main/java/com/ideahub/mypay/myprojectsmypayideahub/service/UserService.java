package com.ideahub.mypay.myprojectsmypayideahub.service;

import com.ideahub.mypay.myprojectsmypayideahub.model.OTP;
import com.ideahub.mypay.myprojectsmypayideahub.model.User;
import com.ideahub.mypay.myprojectsmypayideahub.repository.OTPRepository;
import com.ideahub.mypay.myprojectsmypayideahub.repository.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final OTPService otpService;
    private final OTPRepository otpRepository;
    private final JavaMailSender javaMailSender;

    public UserService(UserRepository userRepository, OTPService otpService, OTPRepository otpRepository, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.otpService = otpService;
        this.otpRepository = otpRepository;
        this.javaMailSender = javaMailSender;
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

        OTP otp = otpService.createNewOTP(userOptional.get().getUserId()); // Get OTP

        // Sending OTP to Email (Used for SMS OTP) -- {}
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("mypaymail66@gmail.com");

        msg.setSubject("OTP for Email and Phone Number Registration");
        msg.setText("Hello, \n\n In this mail, we have attached your OTP for your phone registration and email registration. \n \n OTP : " + otp.getOtpValue());

        javaMailSender.send(msg);

    }

    public void acceptOTPForPhoneNumberAndEmailRegistration(Integer otpValue, Integer phoneNumber) {
        Optional<User> userOptional = userRepository.getUserByPhoneNumber(phoneNumber);

        OTP otp = otpRepository.getOTPByUserUserId(userOptional.get().getUserId());

        System.out.println(otpValue);
        System.out.println(otp.getOtpValue());

        if (!Objects.equals(otpValue, otp.getOtpValue())) {
            throw new IllegalStateException("OTP is not correct!!");
        }

        System.out.println("Phone Number and Email successfully registered");
    }
}
