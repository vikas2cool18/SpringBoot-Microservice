package com.way2learnonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding(MySource.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@StreamListener("helloinchannel")
	public void processGreeting(Greeting greeting) {
		System.err.println("Recevied Greeting  with message ===="+greeting.getMessage());
			
	}

}
