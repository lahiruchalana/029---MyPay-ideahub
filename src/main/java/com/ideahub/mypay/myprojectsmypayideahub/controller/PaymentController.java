package com.ideahub.mypay.myprojectsmypayideahub.controller;

import com.ideahub.mypay.myprojectsmypayideahub.model.Payment;
import com.ideahub.mypay.myprojectsmypayideahub.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "my-pay/api/data/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "users/{userId}/counters/{qrCodeId}")
    public ResponseEntity<Long> getQRCodeAndCreatePayment(
            @PathVariable("qrCodeId") Integer qrCodeId,
            @PathVariable("userId") Long userId
    ) {
        return new ResponseEntity<>(paymentService.getQRCodeAndCreatePayment(qrCodeId, userId), HttpStatus.CREATED);
    }

    @PostMapping(path = "cards/{cardId}/payments/{paymentId}/amounts/{amount}")
    public ResponseEntity<Long> continuePaymentCreating(  // Continue the payment processing after QR code detected
            @PathVariable("cardId") Long cardId,
            @PathVariable("paymentId") Long paymentId,
            @PathVariable("amount") Integer amount
    ) {
        return new ResponseEntity<>(paymentService.continuePaymentCreating(cardId, amount, paymentId), HttpStatus.CREATED);
    }

    @GetMapping(path = "payments/{paymentId}/otps/{otpValue}")
    public ResponseEntity<String> confirmPayment(
            @PathVariable("paymentId") Long paymentId,
            @PathVariable("otpValue") Integer otpValue
    ) {
        return new ResponseEntity<>(paymentService.confirmPayment(otpValue, paymentId), HttpStatus.OK);
    }
}
