package com.ideahub.mypay.myprojectsmypayideahub.service;

import com.ideahub.mypay.myprojectsmypayideahub.model.Card;
import com.ideahub.mypay.myprojectsmypayideahub.repository.CardRepository;
import com.ideahub.mypay.myprojectsmypayideahub.security.AESUtil;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) throws NoSuchAlgorithmException {
        this.cardRepository = cardRepository;
    }

    public void addNewCard(Card card) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        SecretKey key = AESUtil.generateKey(128);
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";

        Card newCard = Card.builder()
                        .number(AESUtil.encrypt(algorithm, card.getNumber(), key, ivParameterSpec))
                                .pin(card.getPin())
                                        .expDate(card.getExpDate())
                                                .user(card.getUser())
                                                        .build();

        cardRepository.save(newCard);
    }

    public Card getCard(Long cardId) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        SecretKey key = AESUtil.generateKey(128);
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";

        Optional<Card> cardOptional = cardRepository.getCardByCardId(cardId);

        if (!cardOptional.isPresent()) {
            throw new IllegalStateException("Card does not exist!!");
        }

        System.out.println(cardOptional.get().getNumber());

        Card card = Card.builder()
                .cardId(cardOptional.get().getCardId())
                .number(AESUtil.decrypt(algorithm, cardOptional.get().getNumber(), key, ivParameterSpec))
                .pin(cardOptional.get().getPin())
                .expDate(cardOptional.get().getExpDate())
                .user(cardOptional.get().getUser())
                .build();

        return card;
    }
}
