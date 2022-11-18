package com.ideahub.mypay.myprojectsmypayideahub.service;

import com.ideahub.mypay.myprojectsmypayideahub.model.Merchant;
import com.ideahub.mypay.myprojectsmypayideahub.repository.MerchantRepository;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public void addNewMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }
}
