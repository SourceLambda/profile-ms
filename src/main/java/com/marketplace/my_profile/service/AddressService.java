package com.marketplace.my_profile.service;

import com.marketplace.my_profile.domain.Address;
import com.marketplace.my_profile.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Iterable<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id){
        return addressRepository.findById(id).get();
    }

    public Address saveAddress(Address address){
        addressRepository.save(address);
        return address;
    }

    public void deleteAddressById(Long id){
        addressRepository.deleteById(id);
    }
}
