package com.marketplace.my_profile.repository;

import com.marketplace.my_profile.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query(value = "select * from Card where id_profile = :profileId", nativeQuery = true)
    Iterable<Card> findCardsByProfile(@Param("profileId") Long profileId);
}
