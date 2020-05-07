package com.way2learnonline;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MySource {
	
	
	//@Output("hellooutchannel")
	//MessageChannel myoutput();
	
	@Input("helloinchannel")
	SubscribableChannel myinput();

}
