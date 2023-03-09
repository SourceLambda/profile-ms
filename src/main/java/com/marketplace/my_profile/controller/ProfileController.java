package com.marketplace.my_profile.controller;

import com.marketplace.my_profile.domain.Profile;
import com.marketplace.my_profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @GetMapping
    public List<Profile> getAllProfiles(){
        return profileService.getProfiles();
    }

    @GetMapping("/{idProfile}")
    public Profile getProfileById(@PathVariable("idProfile")Long idProfile){
        return profileService.getProfileById(idProfile);
    }

    @PostMapping("/saveProfile")
    public void saveUpdateProfile(@RequestBody Profile profile){
        profileService.saveOrUpdateProfile(profile);
    }

    @DeleteMapping("/{idProfile}")
    public void deleteProfile(@PathVariable("idProfile") Long idProfile){
        profileService.deleteProfileById(idProfile);
    }


}
