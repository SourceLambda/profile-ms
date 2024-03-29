package com.marketplace.my_profile.repository;

import com.marketplace.my_profile.domain.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
}
