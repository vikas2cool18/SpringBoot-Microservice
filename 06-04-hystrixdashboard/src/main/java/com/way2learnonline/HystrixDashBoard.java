package com.way2learnonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
// TODO-1 Uncomment below annotation to enable hystrix dashboard
@EnableHystrixDashboard
// TODO-2 Uncomment the below annotation to enable turbine
//@EnableTurbine
@EnableDiscoveryClient
public class HystrixDashBoard {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashBoard.class, args);
	}
}
