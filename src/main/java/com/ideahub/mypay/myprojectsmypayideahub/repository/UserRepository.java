package com.ideahub.mypay.myprojectsmypayideahub.repository;

import com.ideahub.mypay.myprojectsmypayideahub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByPhoneNumber(Integer phoneNumber);

    User findUserByUserId(Long userId);

}
