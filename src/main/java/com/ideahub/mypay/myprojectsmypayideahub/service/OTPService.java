package com.ideahub.mypay.myprojectsmypayideahub.service;

import com.ideahub.mypay.myprojectsmypayideahub.model.OTP;
import com.ideahub.mypay.myprojectsmypayideahub.model.User;
import com.ideahub.mypay.myprojectsmypayideahub.repository.OTPRepository;
import com.ideahub.mypay.myprojectsmypayideahub.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class OTPService {

    private final OTPRepository otpRepository;
    private final UserRepository userRepository;

    public OTPService(OTPRepository otpRepository, UserRepository userRepository) {
        this.otpRepository = otpRepository;
        this.userRepository = userRepository;
    }

    public OTP createNewOTP(Long userId) {
//        otpRepository.refreshTheOTPSchema(); // Refresh expired OTPs

        User user = userRepository.findUserByUserId(userId);

        Optional<OTP> otpOptional = otpRepository.findOTPByUserUserId(userId);
        if (otpOptional.isPresent()) {
            OTP otp = otpRepository.getOTPByUserUserId(userId);
            otpRepository.delete(otp);  // Delete the existing OTP of the relevant user
        }
        
        Random random = new Random();
        Integer otpValue = random.nextInt(99999, 999999); // Create a random OTP

        OTP otpNew = OTP.builder()
                .otpValue(otpValue)
                .user(user)
                .build(); // Create the OTP instance

        otpRepository.save(otpNew);

        return otpNew;
    }

    public OTP getOTP(Long userId) {
        OTP otp = otpRepository.getOTPByUserUserId(userId);

        return otp;
    }

    public void deleteOTP(Long otpId) {
        OTP otp = otpRepository.getOTPByOtpId(otpId);

        otpRepository.delete(otp);
    }

}
