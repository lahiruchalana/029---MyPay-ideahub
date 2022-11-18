package com.ideahub.mypay.myprojectsmypayideahub.repository;

import com.ideahub.mypay.myprojectsmypayideahub.model.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {

    Optional<OTP> findOTPByUserUserId(Long userId);

    OTP getOTPByUserUserId(Long userId);

    OTP getOTPByOtpId(Long otpId);

    @Query(
            value = "DELETE FROM otp_tbl WHERE current_time < (NOW() - INTERVAL 30 second)",
            nativeQuery = true
    )
    void refreshTheOTPSchema(); // remove expired OTPs

}
