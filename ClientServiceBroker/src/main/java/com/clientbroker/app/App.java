package com.clientbroker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.clientbroker.client.RequestExecutor;
import com.clientbroker.util.Constants;


@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.techolution")
public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class);
		RequestExecutor requestExecutor = context.getBean(RequestExecutor.class);
		requestExecutor.getRequest(Constants.GET_ENTRY+"/1");
	
	}
	
}
