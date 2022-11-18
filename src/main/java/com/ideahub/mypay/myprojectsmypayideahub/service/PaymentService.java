package com.ideahub.mypay.myprojectsmypayideahub.service;

import com.ideahub.mypay.myprojectsmypayideahub.model.*;
import com.ideahub.mypay.myprojectsmypayideahub.repository.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CounterRepository counterRepository;
    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private final OTPRepository otpRepository;
    private final OTPService otpService;

    private final JavaMailSender javaMailSender;


    public PaymentService(PaymentRepository paymentRepository, CounterRepository counterRepository, UserRepository userRepository, CardRepository cardRepository, OTPRepository otpRepository, OTPService otpService, JavaMailSender javaMailSender) {
        this.paymentRepository = paymentRepository;
        this.counterRepository = counterRepository;
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.otpRepository = otpRepository;
        this.otpService = otpService;
        this.javaMailSender = javaMailSender;
    }

    public Long getQRCodeAndCreatePayment(Integer qrCodeId, Long userId) {
        Optional<Counter> counterOptional = counterRepository.getCounterByQrCodeId(qrCodeId);

        if (counterOptional.isEmpty()) {
            throw new IllegalStateException("QR code is not available!!");
        }

        Counter counter = counterRepository.findCounterByQrCodeId(qrCodeId);
        User user = userRepository.findUserByUserId(userId);

        Payment payment = Payment.builder()
                .counter(counter)
                .user(user)
                .build();

        paymentRepository.save(payment);

        return payment.getPaymentId();
    }

    public Long continuePaymentCreating(Long cardId, Integer amount, Long paymentId) {
        Optional<Card> cardOptional = cardRepository.getCardByCardId(cardId);

        if (cardOptional.isEmpty()) {
            throw new IllegalStateException("Card is not available!!");
        }

        Card card = cardRepository.findCardByCardId(cardId);

        Payment payment = paymentRepository.getPaymentByPaymentId(paymentId);

        payment.setCard(card);
        payment.setAmount(amount);

        OTP otp = otpService.createNewOTP(payment.getUser().getUserId()); // Get OTP

        // Sending OTP to Email (Used for SMS OTP) -- {}
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("mypaymail66@gmail.com");

        msg.setSubject("OTP for Transaction");
        msg.setText("Hello, \n\n In this mail, we have attached your OTP for Transaction. \n \n OTP : " + otp.getOtpValue());

        javaMailSender.send(msg);

        return payment.getPaymentId();
    }

    public String confirmPayment() {

    }
}
