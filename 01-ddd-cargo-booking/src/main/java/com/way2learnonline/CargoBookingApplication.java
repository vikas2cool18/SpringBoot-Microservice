package com.way2learnonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.way2learnonline.booking.infrastructure.infrastructure.brokers.CargoEventSource;

@SpringBootApplication
@EnableBinding(CargoEventSource.class)
public class CargoBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargoBookingApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
