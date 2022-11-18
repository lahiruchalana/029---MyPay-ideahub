package com.ideahub.mypay.myprojectsmypayideahub.controller;

import com.ideahub.mypay.myprojectsmypayideahub.model.Merchant;
import com.ideahub.mypay.myprojectsmypayideahub.service.MerchantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "my-pay/api/data/merchants")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping
    public ResponseEntity<?> addNewMerchant(
            @RequestBody Merchant merchant
            ) {
        merchantService.addNewMerchant(merchant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
