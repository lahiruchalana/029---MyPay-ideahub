package com.ideahub.mypay.myprojectsmypayideahub.service;

import com.ideahub.mypay.myprojectsmypayideahub.exception.DataExistingException;
import com.ideahub.mypay.myprojectsmypayideahub.model.Counter;
import com.ideahub.mypay.myprojectsmypayideahub.repository.CounterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CounterService {

    private final CounterRepository counterRepository;

    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public void addNewCounter(Counter counter) {
        Optional<Counter> counterOptional = counterRepository.getCounterByQrCodeId(counter.getQrCodeId());

        if (counterOptional.isPresent()) {
            throw new DataExistingException("QR code Id already exist!!");
        }

        counterRepository.save(counter);
    }
}
