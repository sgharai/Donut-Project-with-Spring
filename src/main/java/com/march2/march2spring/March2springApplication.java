package com.march2.march2spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class March2springApplication {

	public String returnsString(String str) {
		return str;
	}

	public static void main(String[] args) {
		SpringApplication.run(March2springApplication.class, args);
	}

}
