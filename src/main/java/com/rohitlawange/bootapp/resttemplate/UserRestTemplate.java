package com.rohitlawange.bootapp.resttemplate;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rohitlawange.bootapp.model.User;

public class UserRestTemplate {

	public static void main(String args[]) {

		RestTemplate template = new RestTemplate();

		String getUrl = "http://localhost:8080/bootapp/hello/rohit";
		String postUrl = "http://localhost:8080/bootapp/createuser";

		ResponseEntity<String> helloResponse = template.getForEntity(getUrl, String.class);
		System.out.println(helloResponse.getBody());
		
		User rohit = new User("rohit", "lawange");
		User user = template.postForObject(postUrl, rohit, User.class);
		System.out.println("user returned from the API : "+user.getFirstName());
		
		//using resttemaplate exchange 
		//instead of sending null, we can send the httpEntity 
		ResponseEntity<String> helloResponse2 =template.exchange(getUrl, HttpMethod.GET, null, String.class);
		System.out.println("response using the exchange method of the template : "+helloResponse2.getBody());
	}
}
