package com.marketplace.my_profile.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Profile")
public class Profile {
    @Id
    @Column(name = "id_profile")
    private Long idProfile;
    private String firstname;
    private String lastname;
    private Integer telNumber;
    private String email;
    private Date birthday;
    @Column(name = "alternative_number", nullable = true)
    private Integer alternativeNumber;

    @OneToMany(
            targetEntity = Card.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "profile"
    )
    private List<Card> cards;

    @OneToMany(
            targetEntity = Address.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "profile"
    )
    private List<Address> addresses;
}
