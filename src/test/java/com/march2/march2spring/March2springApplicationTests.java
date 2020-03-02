package com.march2.march2spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class March2springApplicationTests {

	March2springApplication main;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void init() {
		main = new March2springApplication();
	}


	@Test
	void main() {
		assertEquals(9, 5+4);
	}

	@Test
	void returnsStringCheck(){
		assertEquals(String.class, main.returnsString("Hello").getClass());
		System.out.println(main.returnsString("Hello").getClass());
	}

}
