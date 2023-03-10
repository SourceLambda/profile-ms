package com.marketplace.my_profile.service;

import com.marketplace.my_profile.domain.Address;
import com.marketplace.my_profile.domain.Card;
import com.marketplace.my_profile.domain.Profile;
import com.marketplace.my_profile.repository.AddressRepository;
import com.marketplace.my_profile.repository.CardRepository;
import com.marketplace.my_profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    AddressRepository addressRepository;
    //sección del admin
    public Iterable<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id){
        return profileRepository.findById(id).get();
    }

    public void saveOrUpdateProfile(Profile profile){
        profileRepository.save(profile);
    }

    public void deleteProfileById(Long id){
        profileRepository.deleteById(id);
    }

    //sección del User en su profile
    public Iterable<Card> getCardsByProfile(Long idProfile){
        return profileRepository.findCardsByProfile(idProfile);
    }
    public Iterable<Address> getAddressesByProfile(Long idProfile){
        return profileRepository.findAddressByProfile(idProfile);
    }


}
