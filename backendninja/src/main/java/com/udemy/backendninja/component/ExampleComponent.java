package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ExampleComponent {
	public static Log LOGGER = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHello(){
		
		LOGGER.info("Hello from ExampleComponent");
	}
}
