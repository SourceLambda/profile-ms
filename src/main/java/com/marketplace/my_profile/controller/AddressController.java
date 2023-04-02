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

    @PutMapping("/address/{idAddress}")
    public Address updateAddress(@RequestBody Address address){
        addressService.saveAddress(address);
        return address;
    }

    @PostMapping("/profile/{idProfile}/address")
    public Address saveAddress(@RequestBody Address address, @PathVariable Long idProfile){
        Profile profile = profileService.getProfileById(idProfile);
        address.setProfile(profile);
        addressService.saveAddress(address);
        return address;
    }

    @DeleteMapping("/address/{idAddress}")
    public Long deleteAddress(@PathVariable("idAddress") Long idAddress){
        addressService.deleteAddressById(idAddress);
        return idAddress;
    }
}
