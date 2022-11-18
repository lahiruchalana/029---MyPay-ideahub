package com.ideahub.mypay.myprojectsmypayideahub.controller;

import com.ideahub.mypay.myprojectsmypayideahub.model.Counter;
import com.ideahub.mypay.myprojectsmypayideahub.service.CounterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "my-pay/api/data/counters")
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping
    public ResponseEntity<?> addNewCounter(
            @RequestBody Counter counter
            ) {
        counterService.addNewCounter(counter);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
