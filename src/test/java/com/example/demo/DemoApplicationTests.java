package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	// Positive test case: test existing endpoint /test
	@Test
	void testEndpointSuccess() throws Exception {
		// Make a request to localhost:8080/test and expect a 200 status
		mockMvc.perform(get("/test"))
				.andExpect(status().isOk())
				.andExpect(content().string("endpoint is working :)"));
	}


	// Negative test case: test endpoint that does not exist
	@Test
	void testNotFoundEndpoint() throws Exception {
		// Make a request to localhost:8080/doesnotexist and expect a 404 status
		mockMvc.perform(get("/doesnotexist"))
				.andExpect(status().isNotFound());
	}

	// Positive test case: Test that the endpoint works by visiting Google
	@Test
	void testGoogleEndpoint() {
		Scraper scraper = new Scraper();
		scraper.driver.get("https://www.google.com");

		// Assert that the title contains "Google"
		assertTrue(scraper.driver.getTitle().contains("Google"));

		// Add more assertions as needed for elements or conditions on the page
	}

	 // Negative test case: Test that the endpoint fails to reach an invalid URL
	 @Test
	 void testEndpointFails() {
		 Scraper scraper = new Scraper();
 
		 try {
			 // Intentionally set an invalid URL to trigger a failure
			 String invalidUrl = "https://www.invalidurl.com";
			 scraper.driver.get(invalidUrl);
 
			 // If the above line doesn't throw an exception, fail the test
			 assertFalse(true);
		 } catch (Exception e) {
			 // The test passes if an exception is thrown
			 assertTrue(true);
		 }
	 }

	 // add a test that will fail
	 @Test
	 void testFail() {
		 assertTrue(false);
	 }

}
