package com.kurki.tekniikat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kurki.tekniikat.bean.Friend;
import com.kurki.tekniikat.bean.Student;

@Controller
public class DemoController {
	
	List<Student> students = new ArrayList<Student>();
	List<Friend> friends = new ArrayList<Friend>();
	
	@RequestMapping("/hello")
	public String checkDetails(@RequestParam(value="name") String name, @RequestParam(value="age") int age, Model model){
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "hello";
	}
	@RequestMapping("/addStudent")
	public String addStudent(@RequestParam(value="fname") String fname, @RequestParam(value="lname") String lname, @RequestParam(value="email") String email, Model model){
		Student student = new Student(fname,lname,email);
		students.add(student);
		model.addAttribute("students", students);
		return "student";
	}
	
	@RequestMapping("/index")
	public String myFriends(Model model){
		Friend tyhjaFriend = new Friend();
		model.addAttribute("friend", tyhjaFriend);
		return "index";
	}
	
	@RequestMapping("/addFriend")
	public String addFriend(Model model, Friend friend){
		friends.add(friend);
		model.addAttribute("friends", friends);
		return "index";
	}

}
