package com.marketplace.my_profile.service;

import com.marketplace.my_profile.domain.Card;
import com.marketplace.my_profile.domain.PersonalData;
import com.marketplace.my_profile.domain.Profile;
import com.marketplace.my_profile.repository.CardRepository;
import com.marketplace.my_profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    CardRepository cardRepository;

    //sección del admin
    public List<Profile> getProfiles(){
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
    public List<Card> getCardsByProfile(Long idProfile){
        return cardRepository.findCardsByProfile(idProfile);
    }

    public void createCardByProfile(long idProfile){

    }

}
