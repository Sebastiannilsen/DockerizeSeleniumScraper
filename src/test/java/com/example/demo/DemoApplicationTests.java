package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testEndpointWorks() {
		Scraper scraper = new Scraper();
		scraper.driver.get("https://www.google.com");
	}

}
