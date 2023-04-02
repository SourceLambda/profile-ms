package com.marketplace.my_profile.controller;

import com.marketplace.my_profile.domain.Address;
import com.marketplace.my_profile.domain.Card;
import com.marketplace.my_profile.domain.Profile;
import com.marketplace.my_profile.service.AddressService;
import com.marketplace.my_profile.service.CardService;
import com.marketplace.my_profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @Autowired
    CardService cardService;
    @Autowired
    AddressService addressService;

    @GetMapping
    public Iterable<Profile> getAllProfiles(){
        return profileService.getProfiles();
    }

    @GetMapping("/{idProfile}")
    public Profile getProfileById(@PathVariable("idProfile")Long idProfile){
        return profileService.getProfileById(idProfile);
    }

    @PutMapping("/{idProfile}")
    public Profile updateProfile(@RequestBody Profile profile){
        profileService.saveProfile(profile);
        return profile;
    }

    @PostMapping()
    public Profile saveProfile(@RequestBody Profile profile){
        profileService.saveProfile(profile);
        return profile;
    }

    @DeleteMapping("/{idProfile}")
    public Long deleteProfile(@PathVariable("idProfile")Long idProfile){
        profileService.deleteProfileById(idProfile);
        return idProfile;
    }

    @GetMapping("/{idProfile}/cards")
    public Iterable<Card> getCardsByProfileId(@PathVariable("idProfile")Long idProfile){
        return profileService.getCardsByProfile(idProfile);
    }
    @GetMapping("/{idProfile}/cards/{idCard}")
    public Card getCardFromProfileCards(@PathVariable("idProfile")Long idProfile, @PathVariable("idCard")Long idCard){
        Iterable<Card> cards = profileService.getCardsByProfile(idProfile);
        Card addressToReturn = new Card();
        for(Card card: cards){
            if(card.getIdCard().equals(idCard)){
                addressToReturn.setIdCard(card.getIdCard());
                addressToReturn.setProfile(card.getProfile());
                addressToReturn.setCardName(card.getCardName());
                addressToReturn.setCardNickname(card.getCardNickname());
                addressToReturn.setCvv(card.getCvv());
                addressToReturn.setExpirationDate(card.getExpirationDate());
                addressToReturn.setCardNumber(card.getCardNumber());
            }
        }
        return addressToReturn;
    }
    @GetMapping("/{idProfile}/addresses")
    public Iterable<Address> getAddressesByProfileId(@PathVariable("idProfile") Long idProfile){
        return profileService.getAddressesByProfile(idProfile);
    }

    @GetMapping("/{idProfile}/addresses/{idAddress}")
    public Address getAddressFromProfileAddresses(@PathVariable("idProfile")Long idProfile, @PathVariable("idAddress")Long idAddress){
        Iterable<Address> addresses = profileService.getAddressesByProfile(idProfile);
        Address addressToReturn = new Address();
        for(Address address: addresses){
            if(address.getIdAddress().equals(idAddress)){
                addressToReturn.setIdAddress(address.getIdAddress());
                addressToReturn.setProfile(address.getProfile());
                addressToReturn.setAddress(address.getAddress());
                addressToReturn.setDetailAddress(address.getDetailAddress());
            }
        }
        return addressToReturn;
    }


}
