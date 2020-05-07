package com.way2learnonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

import com.way2learnonline.tracking.infrastructure.brokers.CargoEventSource;

@SpringBootApplication
@EnableBinding(CargoEventSource.class)
public class CargotrackertrackingspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargotrackertrackingspringApplication.class, args);
	}

}
