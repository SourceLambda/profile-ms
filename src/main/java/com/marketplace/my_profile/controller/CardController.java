package com.marketplace.my_profile.controller;

import com.marketplace.my_profile.domain.Card;
import com.marketplace.my_profile.domain.Profile;
import com.marketplace.my_profile.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping
    public List<Card> getAllCards(){
        return cardService.getCards();
    }

    @GetMapping("/{idCard}")
    public Card getCardById(@PathVariable("idCard")Long idCard){
        return cardService.getCardById(idCard);
    }

    @PostMapping("/saveCard")
    public void saveUpdateProfile(@RequestBody Card card){
        cardService.saveOrUpdateCard(card);
    }

    @DeleteMapping("/{idCard}")
    public void deleteCard(@PathVariable("idCard") Long idCard){
        cardService.deleteCardById(idCard);
    }
}
