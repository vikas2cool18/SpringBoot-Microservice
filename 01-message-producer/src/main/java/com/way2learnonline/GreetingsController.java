package com.way2learnonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GreetingsController {

	@Autowired
	private MySource source;

	@GetMapping("/greet")
	public Greeting createGreeting(String message) {
		
		Greeting greeting=new Greeting(message);
		System.err.println("Sending greeting!! ");
		
		source.myoutput().send(MessageBuilder.withPayload(greeting).build());
		
		return greeting;
		
	}
	

}
