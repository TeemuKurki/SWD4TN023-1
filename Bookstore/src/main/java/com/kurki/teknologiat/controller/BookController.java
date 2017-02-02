package com.kurki.teknologiat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kurki.teknologiat.model.Book;
import com.kurki.teknologiat.repository.BookRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepo;
	
	@RequestMapping("/booklist")
	public String getBooks(Model model){
		model.addAttribute("book", new Book());
		model.addAttribute("books", bookRepo.findAll());
		return "booklist";	
	}
	
	@RequestMapping("/addBook")
	public String addBook(Model model,Book book){
		bookRepo.save(book);
		return "redirect:/booklist";	
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable long id){
		bookRepo.delete(bookRepo.findOne(id));
		return "redirect:/booklist";	
	}

}
