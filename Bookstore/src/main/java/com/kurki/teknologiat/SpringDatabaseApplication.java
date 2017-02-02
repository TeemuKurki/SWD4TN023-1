package com.kurki.teknologiat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kurki.teknologiat.model.Book;
import com.kurki.teknologiat.repository.BookRepository;

@SpringBootApplication
public class SpringDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository){
		return (args) -> {
			Book book1 = new Book("Koodausmestarin ristiretki", "Mikka", "100932", 2000, 30);
			Book book2 = new Book("Koodausmestarin lankeemus", "Mikka", "108932", 2003, 40);
			bookRepository.save(book1);
			bookRepository.save(book2);
		};
	}
}
