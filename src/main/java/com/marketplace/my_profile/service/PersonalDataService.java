package com.marketplace.my_profile.service;

import com.marketplace.my_profile.domain.PersonalData;
import com.marketplace.my_profile.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDataService {
    @Autowired
    PersonalDataRepository personalDataRepository;

    public List<PersonalData> getPersonalData(){
        return personalDataRepository.findAll();
    }

    public PersonalData getPersonalDataById(Long id){
        return personalDataRepository.findById(id).get();
    }

    public void saveOrUpdatePersonalData(PersonalData personalData){
        personalDataRepository.save(personalData);
    }

    public void deletePersonalById(Long id){
        personalDataRepository.deleteById(id);
    }
}
