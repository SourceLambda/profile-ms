package com.marketplace.my_profile.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCard;
    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "id_profile")
    private Profile profile;

    @Column(name = "card_number")
    private Long cardNumber;
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Column(name = "CVV")
    private Integer cvv;
    @Column(name = "card_person_name")
    private String cardName;
    @Column(name = "card_nickname")
    private String cardNickname;


}
