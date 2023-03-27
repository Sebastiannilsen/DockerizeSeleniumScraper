package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scraper {
  WebDriver driver;



  public Scraper() {
    WebDriverManager.chromedriver().setup();

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
