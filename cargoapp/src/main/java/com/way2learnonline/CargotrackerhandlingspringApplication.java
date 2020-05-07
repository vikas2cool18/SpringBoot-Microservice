package com.way2learnonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.way2learnonline.handling.infrastructure.brokers.rabbitmq.CargoEventSource;

@SpringBootApplication
@EnableBinding(CargoEventSource.class)
public class CargotrackerhandlingspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargotrackerhandlingspringApplication.class, args);
	}

}
