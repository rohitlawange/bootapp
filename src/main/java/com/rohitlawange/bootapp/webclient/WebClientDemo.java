package com.rohitlawange.bootapp.webclient;

import org.springframework.web.reactive.function.client.WebClient;

import com.rohitlawange.bootapp.model.User;

import reactor.core.publisher.Mono;

public class WebClientDemo {

	
	public static void  main(String args[]) {
		WebClient webClient = WebClient.create("http://localhost:8080/bootapp");
		
	 //I willl make a call to the get call
		
		
		//post call
		User user = new User("shubani", "kadu");
		Mono<User> res = webClient.post().uri("/createuser").bodyValue(user).retrieve().bodyToMono(User.class);
		System.out.println(res.block());
	}
}
