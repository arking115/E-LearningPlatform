package com.example.jpa;

import com.example.jpa.models.Author;
import com.example.jpa.models.Video;
import com.example.jpa.repositories.AuthorRepository;
import com.example.jpa.repositories.VideoRepository;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner commandLineRunner(
		AuthorRepository authorRepository,
		VideoRepository videoRepository
	) {
		return args -> {
			System.out.println(authorRepository.findAllByFirstName("Valorie"));
			System.out.println(authorRepository.findAllByFirstNameIgnoreCase("Grady"));
			System.out.println(authorRepository.findAllByFirstNameContainingIgnoreCase("na"));
			System.out.println(authorRepository.findAllByFirstNameStartingWithIgnoreCase("mA"));
			System.out.println(authorRepository.findAllByFirstNameEndsWithIgnoreCase("eR"));
			System.out.println(authorRepository.findAllByFirstNameInIgnoreCase(List.of(new String[]{"AN", "aS"})));
//			for (int i = 0; i <= 50; i++) {
//				Faker faker = new Faker();
//				var author = Author.builder()
//						.firstName(faker.name().firstName())
//						.lastName(faker.name().lastName())
//						.age(faker.number().numberBetween(19, 50))
//						.email("rusalexandru115@gmail.com")
////						.courses(new ArrayList<>())
//						.build();
//				authorRepository.save(author);
//			}
//			var video = Video.builder()
//					.name("abc")
//					.length(5)
//					.url("dawg")
//					.build();
//			videoRepository.save(video);
		};
	}

}
