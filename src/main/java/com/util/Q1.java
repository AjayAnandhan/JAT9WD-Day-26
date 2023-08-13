package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		driver.switchTo().frame(0);

		WebElement b = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));

		b.clear();
		
		b.sendKeys("Hello People");
		
		System.out.println(b.getText());
		
		driver.quit();
		
	}

}
