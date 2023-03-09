package com.marketplace.my_profile.repository;

import com.marketplace.my_profile.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query(value = "select * from Card where id_profile = ?1")
    List<Card> findCardsByProfile(Long idProfile);
}
