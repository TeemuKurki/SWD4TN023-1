package com.kurki.teknologiat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kurki.teknologiat.model.Book;
import com.kurki.teknologiat.model.User;
import com.kurki.teknologiat.repository.BookRepository;
import com.kurki.teknologiat.repository.UserRepository;

@SpringBootApplication
public class SpringDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, UserRepository userReporitory){
		return (args) -> {
			User user = new User("userTeemu","$2a$04$3QHLpPuoCFP/.gC8KHc6mepo/i5ye82JyxN6UClOs4gHLfUSVpzMm","teemu@mail.com","USER");
			User user2 = new User("adminTeemu", "$2a$04$4ogYBU3dssD3J6YOskhhouSlkxJUHwOJo8UAv0e8peaV/mvRE0WiK", "teemu@mainl.com", "ADMIN");
			Book book1 = new Book("Koodausmestarin ristiretki", "Mikka", "100932", 2000, 30);
			Book book2 = new Book("Koodausmestarin lankeemus", "Mikka", "108932", 2003, 40);
			bookRepository.save(book1);
			bookRepository.save(book2);
			userReporitory.save(user);
			userReporitory.save(user2);
		};
	}
}
