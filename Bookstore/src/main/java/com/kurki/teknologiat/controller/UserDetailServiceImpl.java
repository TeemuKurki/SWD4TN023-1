package com.kurki.teknologiat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kurki.teknologiat.model.User;
import com.kurki.teknologiat.repository.UserRepository;

/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	private final UserRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository){
		this.repository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User currentUser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(),
				AuthorityUtils.createAuthorityList(currentUser.getRole()));
		System.out.println(AuthorityUtils.createAuthorityList(currentUser.getRole()));
		return user;
	}
}
