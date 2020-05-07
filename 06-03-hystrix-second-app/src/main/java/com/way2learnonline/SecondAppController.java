package com.way2learnonline;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SecondAppController {

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping
	public String hystrixSecondMethod() {

		if (RandomUtils.nextInt(10) > 5) {
			return "SecondAppResponse!!";
		}
		throw new RuntimeException();
	}
	
	

	public String fallback() {
		return "SecondAppFallback";
	}

}
