package com.marketplace.my_profile.controller;

import com.marketplace.my_profile.domain.Card;
import com.marketplace.my_profile.domain.Profile;
import com.marketplace.my_profile.service.CardService;
import com.marketplace.my_profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    CardService cardService;
    @Autowired
    ProfileService profileService;
    @GetMapping("/card")
    public Iterable<Card> getAllCards(){
        return cardService.getCards();
    }

    @GetMapping("/card/{idCard}")
    public Card getCardById(@PathVariable("idCard")Long idCard){
        return cardService.getCardById(idCard);
    }

    @PostMapping("/profile/{idProfile}/card")
    public Card saveCard(@RequestBody Card card, @PathVariable Long idProfile){
        Profile profile = profileService.getProfileById(idProfile);
        card.setProfile(profile);
        cardService.saveCard(card);
        return card;
    }

    @DeleteMapping("/profile/{idProfile}/cards/{idCard}")
    public Long deleteCard(@PathVariable("idCard")Long idCard, @PathVariable("idProfile")Long idProfile){
        Profile profile = profileService.getProfileById(idProfile);
        Card cardToDelete = cardService.getCardById(idCard);
        profile.getCards().remove(cardToDelete);
        cardService.deleteCardById(idCard);
        return idCard;
    }
}
