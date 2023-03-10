package com.marketplace.my_profile.repository;

import com.marketplace.my_profile.domain.Address;
import com.marketplace.my_profile.domain.Card;
import com.marketplace.my_profile.domain.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @Query(value = "(SELECT * FROM address WHERE id_profile = :idProfile)", nativeQuery = true)
    Iterable<Address> findAddressByProfile(@Param("idProfile") Long idProfile);

    @Query(value = "(select * from Card where id_profile = :profileId)", nativeQuery = true)
    Iterable<Card> findCardsByProfile(@Param("profileId") Long profileId);
}
