package com.ideahub.mypay.myprojectsmypayideahub.repository;

import com.ideahub.mypay.myprojectsmypayideahub.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> getCardByNumber(Integer number);

    Optional<Card> getCardByCardId(Long cardId);

    Card findCardByCardId(Long cardId);
}
