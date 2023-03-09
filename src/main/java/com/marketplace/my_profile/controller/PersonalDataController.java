package com.marketplace.my_profile.controller;

import com.marketplace.my_profile.domain.PersonalData;
import com.marketplace.my_profile.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/personal-data")
public class PersonalDataController {
    @Autowired
    PersonalDataService personalDataService;

    @GetMapping
    public List<PersonalData> getAllPersonalData(){
        return personalDataService.getPersonalData();
    }

    @GetMapping("/{idPersonalData}")
    public PersonalData getPersonalDataById(@PathVariable("idPersonalData") Long idPersonalData){
        return personalDataService.getPersonalDataById(idPersonalData);
    }

    @PostMapping
    public void saveUpdatePersonalData(@RequestBody PersonalData personalData){
        personalDataService.saveOrUpdatePersonalData(personalData);
    }

    @DeleteMapping("/{idPersonalData}")
    public void deletePersonalData(@PathVariable("idPersonalData") Long idPersonalData){
        personalDataService.deletePersonalById(idPersonalData);
    }
}
