package com.way2learnonline;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FirstAppController {

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping
	public String hystrixFirstMethod() {

		if (RandomUtils.nextInt(10) > 5) {
			return "FirstAppResponse";
		}
		throw new RuntimeException();
	}
	
	

	public String fallback() {
		return "Fallback";
	}

}
