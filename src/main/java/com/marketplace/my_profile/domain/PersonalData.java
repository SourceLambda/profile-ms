package com.marketplace.my_profile.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PersonalData")
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal_data")
    private Long idPersonalData;
    private String firstname;
    private String lastname;
    private Integer telNumber;
    @Column(name = "alternative_number", nullable = true)
    private Integer alternativeNumber;
    @Column(name = "id_person", unique = true, nullable = false)
    private Integer idPerson;


}
