package com.ideahub.mypay.myprojectsmypayideahub.service;

import com.ideahub.mypay.myprojectsmypayideahub.model.Outlet;
import com.ideahub.mypay.myprojectsmypayideahub.repository.OutletRepository;
import org.springframework.stereotype.Service;

@Service
public class OutletService {

    private final OutletRepository outletRepository;

    public OutletService(OutletRepository outletRepository) {
        this.outletRepository = outletRepository;
    }

    public void addNewOutlet(Outlet outlet) {
        outletRepository.save(outlet);
    }
}
