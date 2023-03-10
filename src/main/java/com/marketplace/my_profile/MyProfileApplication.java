package com.marketplace.my_profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProfileApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner commandLineRunner(
			ProfileRepository profileRepository,
			PersonalDataRepository personalDataRepository,
			CardRepository cardRepository
	){
		return args -> {
			PersonalData personalData1 = personalDataRepository.save(new PersonalData(null, "Camilo", "Tatis", 3123, 1231, 123234));
			Profile profile1 = profileRepository.save(new Profile(null, "ctatis", "asd",personalData1, null));
			Card card1 = cardRepository.save(new Card(null, 1236585, Date.valueOf("2026-02-23"),  123, "Camilo Tatis", "Tarjeta", profile1));
			Card card2 = cardRepository.save(new Card(null, 98752, Date.valueOf("2027-10-03"), 123, "Jose Moreno", "Tarjeta 2", profile1));

			profile1.setCardSet(Set.of(card1,card2));
			System.out.println(profile1.toString());
		};
	}*/
}
