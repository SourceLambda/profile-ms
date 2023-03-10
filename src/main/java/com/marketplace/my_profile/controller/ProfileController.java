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

    @PostMapping()
    public void saveProfile(@RequestBody Profile profile){
        profileService.saveOrUpdateProfile(profile);
    }

    @DeleteMapping("/{idProfile}")
    public void deleteProfile(@PathVariable("idProfile") Long idProfile){
        profileService.deleteProfileById(idProfile);
    }

    @GetMapping("/{idProfile}/cards")
    public Iterable<Card> getCardsByProfileId(@PathVariable("idProfile")Long idProfile){
        return profileService.getCardsByProfile(idProfile);
    }
    @GetMapping("/{idProfile}/addresses")
    public Iterable<Address> getAddressesByProfileId(@PathVariable("idProfile") Long idProfile){
        return profileService.getAddressesByProfile(idProfile);
    }


}
