package com.kurki.teknologiat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurki.teknologiat.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
