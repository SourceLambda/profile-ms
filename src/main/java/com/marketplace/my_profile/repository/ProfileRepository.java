package com.marketplace.my_profile.repository;

import com.marketplace.my_profile.domain.Address;
import com.marketplace.my_profile.domain.Card;
import com.marketplace.my_profile.domain.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @Query(value = "SELECT a FROM Address a WHERE a.profile = ?1")
    Iterable<Address> findAddressByProfile(Optional<Profile> Profile);

    @Query(value = "SELECT c FROM Card c WHERE c.profile = ?1")
    Iterable<Card> findCardsByProfile(Optional<Profile> Profile);
}
