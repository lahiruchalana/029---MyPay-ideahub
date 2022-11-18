package com.ideahub.mypay.myprojectsmypayideahub.controller;

import com.ideahub.mypay.myprojectsmypayideahub.model.Outlet;
import com.ideahub.mypay.myprojectsmypayideahub.service.OutletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "my-pay/api/data/outlets")
public class OutletController {

    private final OutletService outletService;

    public OutletController(OutletService outletService) {
        this.outletService = outletService;
    }

    @PostMapping
    public ResponseEntity<?> addNewOutlet(
            @RequestBody Outlet outlet
            ) {
        outletService.addNewOutlet(outlet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
