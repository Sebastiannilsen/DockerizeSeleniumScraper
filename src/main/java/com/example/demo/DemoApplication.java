package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@RestController
	class ScraperController {
		@GetMapping("/get-title")
		public String getTitle() {
			Scraper scraper = new Scraper();
			return scraper.getTitle();
		}
	}

}
