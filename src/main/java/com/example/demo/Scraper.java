package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Scraper {
  WebDriver driver;



  public Scraper() {
    // find the chrome driver
    File file = new File("/usr/bin/chromedriver");
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

    ChromeOptions options = new ChromeOptions();

    options.addArguments("--window-size=1920,1080");
    options.addArguments("--no-sandbox");
    options.addArguments("--headless");
    options.addArguments("--disable-gpu");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--remote-allow-origins=*");
    //options.addArguments("--whitelisted-ips=*");

    driver = new ChromeDriver(options);

    driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
    System.out.println(driver.getTitle());
  }
}
