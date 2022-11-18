package com.ideahub.mypay.myprojectsmypayideahub.service;

import com.ideahub.mypay.myprojectsmypayideahub.model.Counter;
import com.ideahub.mypay.myprojectsmypayideahub.repository.CounterRepository;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private final CounterRepository counterRepository;

    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public void addNewCounter(Counter counter) {
        counterRepository.save(counter);
    }
}
