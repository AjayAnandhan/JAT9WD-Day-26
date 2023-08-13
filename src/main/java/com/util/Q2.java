package com.util;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		
		Set<String> handle = driver.getWindowHandles();
		
		List<String> myList = new ArrayList<String>(handle);
		
		driver.switchTo().window(myList.get(1));
		
		WebElement a = driver.findElement(By.xpath("/html/body/div/h3"));
		
		String s = a.getText();
		
		if(s.contains("New Window")) {
			System.out.println("Successfully opened new window");
			driver.close();
		}
		else {
			System.out.println("New window isn't opened");
			driver.quit();
		}
		
		driver.switchTo().window(myList.get(0));
		
		String s2 = driver.getTitle();
		
		if (s2.contains("The Internet")) {
			System.out.println("Parent window is active");
			driver.quit();
		}
		else {
			System.out.println("Parent window is inactive");
			driver.quit();
		}
		
	}

}
