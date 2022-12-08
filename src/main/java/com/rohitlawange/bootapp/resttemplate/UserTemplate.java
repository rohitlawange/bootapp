package com.rohitlawange.bootapp.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rohitlawange.bootapp.model.User;

@Component
public class UserTemplate {

	@Autowired
	RestTemplate template;
	
	public User creatUserApi(User user) {
		
		String postUrl = "http://localhost:8080/bootapp/createuser";
		User ji = new User(user.getFirstName(), user.getLastName()+"ji");
		User response = template.postForObject(postUrl, ji, User.class);
		System.out.println("user returned from the API : "+response.getFirstName());
		
		return response;
		
	}
}
