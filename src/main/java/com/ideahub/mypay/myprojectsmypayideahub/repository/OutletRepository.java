package com.ideahub.mypay.myprojectsmypayideahub.repository;

import com.ideahub.mypay.myprojectsmypayideahub.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletRepository extends JpaRepository<Outlet, Long> {


}
