package com.ideahub.mypay.myprojectsmypayideahub.controller;

import com.ideahub.mypay.myprojectsmypayideahub.model.Card;
import com.ideahub.mypay.myprojectsmypayideahub.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping(path = "my-pay/api/data/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<Card> addNewCard(
            @RequestBody Card card
    ) {
        try {
            cardService.addNewCard(card);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "cards/{cardId}")
    public ResponseEntity<Card> getCardData(
            @PathVariable("cardId") Long cardId
    ) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return new ResponseEntity<>(cardService.getCard(cardId), HttpStatus.OK);
    }

}
