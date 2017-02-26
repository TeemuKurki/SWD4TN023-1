package com.kurki.teknologiat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kurki.teknologiat.model.Book;
import com.kurki.teknologiat.repository.BookRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepo;
	
	/*@RequestMapping("*")
	public String login(){
		return "login";
	}*/
	
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
	
	//REST alkaa tästä
	
	@RequestMapping("/getAll")
	public @ResponseBody List<Book> bookListJson(){
		return (List<Book>) bookRepo.findAll();
	}
	
	@RequestMapping("getBook/{id}")
	public @ResponseBody Book getBookJson(@PathVariable long id){
		return bookRepo.findOne(id);
	}

}
