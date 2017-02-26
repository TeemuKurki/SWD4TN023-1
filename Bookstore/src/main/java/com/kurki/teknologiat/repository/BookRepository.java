package com.kurki.teknologiat.repository;

import org.springframework.data.repository.CrudRepository;

import com.kurki.teknologiat.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
