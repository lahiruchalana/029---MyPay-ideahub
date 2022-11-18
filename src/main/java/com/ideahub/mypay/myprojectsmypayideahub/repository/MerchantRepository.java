package com.ideahub.mypay.myprojectsmypayideahub.repository;

import com.ideahub.mypay.myprojectsmypayideahub.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {


}
