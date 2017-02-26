package com.kurki.teknologiat.repository;

import org.springframework.data.repository.CrudRepository;

import com.kurki.teknologiat.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
