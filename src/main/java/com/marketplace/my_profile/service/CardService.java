package com.marketplace.my_profile.service;

import com.marketplace.my_profile.domain.Card;
import com.marketplace.my_profile.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public List<Card> getCards(){
        return cardRepository.findAll();
    }
    public Card getCardById(Long id){
        return cardRepository.findById(id).get();
    }
    public void saveOrUpdateCard(Card card){
        cardRepository.save(card);
    }
    public void deleteCardById(Long id){
        cardRepository.deleteById(id);
    }
}
