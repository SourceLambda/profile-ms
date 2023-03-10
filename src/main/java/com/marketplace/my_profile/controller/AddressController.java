package com.marketplace.my_profile.controller;

import com.marketplace.my_profile.domain.Address;
import com.marketplace.my_profile.domain.Profile;
import com.marketplace.my_profile.service.AddressService;
import com.marketplace.my_profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api")
public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    ProfileService profileService;

    @GetMapping("/address")
    public Iterable<Address> getAllAddress(){
        return addressService.getAddresses();
    }

    @GetMapping("/address/{idAddress}")
    public Address getAddressById(@PathVariable("idAddress") Long idAddress){
        return addressService.getAddressById(idAddress);
    }

    @PostMapping("/profile/{idProfile}/address")
    public void saveUpdateAddress(@RequestBody Address address, @PathVariable Long idProfile){
        Profile profile = profileService.getProfileById(idProfile);
        address.setProfile(profile);
        addressService.saveOrUpdateAddress(address);
    }

    @DeleteMapping("/address/{idAddress}")
    public void deleteAddress(@PathVariable("idAddress") Long idAddress){
        addressService.deleteAddressById(idAddress);
    }
}
