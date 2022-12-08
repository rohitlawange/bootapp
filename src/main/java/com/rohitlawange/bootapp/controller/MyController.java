package com.rohitlawange.bootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohitlawange.bootapp.model.User;
import com.rohitlawange.bootapp.resttemplate.UserTemplate;

@RestController
@RequestMapping("/bootapp")
public class MyController {

	@Autowired
	UserTemplate userTemplate;
	
	@GetMapping("/hello/{name}")
	public ResponseEntity<String> hello(@PathVariable(name = "name") String name) {

		System.out.println("made a call to the controller with name : " + name);
		return ResponseEntity.ok("Hello " + name);
	}
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		System.out.println("user created with firstName : "+user.getFirstName());
		//need to create  service class and need to add code to persist this object
		//need to learn about the H2 so that it will be easy to store the objects
		user.setFirstName("Mr "+user.getFirstName());
		return ResponseEntity.ok(user);
		
	}
	
	//api to capitalize the strings passed in the url
	@GetMapping("/capitalize/{string}")
	public ResponseEntity<String> capitlizeString(@PathVariable(name ="string") String str){
		
		System.out.println("capitalizing string : "+str);
		//need to create  service class and need to add code to persist this object
		//need to learn about the H2 so that it will be easy to store the objects
		
		return ResponseEntity.ok(str.toUpperCase());
		
	}
	
	
	//this api just calls the API above with some modifictaion using a resttemplate, so the call is not internal
	//this was done to test the resttemplate within the application itself. actually this is a bad practise in reality
	@PostMapping("/createspecialuser")
	public ResponseEntity<User> createSpecialUser(@RequestBody User user){
		
		System.out.println("creating special user with firstName : "+user.getFirstName());
		System.out.println("calling special api with user name");
		User response = userTemplate.creatUserApi(user);
		
		System.out.println("got a reposne from the rest template");
		//need to create  service class and need to add code to persist this object
		//need to learn about the H2 so that it will be easy to store the objects
		//user.setFirstName("Mr "+user.getFirstName());
		return ResponseEntity.ok(response);
		
	}
	
	
	
	

	//todo : implement all the crud operations in this
}
