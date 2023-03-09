package com.marketplace.my_profile.domain;

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
    @Column(name = "card_number")
    private Integer cardNumber;
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Column(name = "CVV")
    private Integer cvv;
    @Column(name = "card_person_name")
    private String cardName;
    @Column(name = "card_nickname")
    private String cardNickname;

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "idProfile")
    private Profile profile;

}
