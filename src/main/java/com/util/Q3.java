package com.util;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame(0);
		
		List<WebElement> iframe = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframe);
		
		driver.switchTo().frame(0);
		
		WebElement leftFrame = driver.findElement(By.xpath("/html/body"));
		String str1 = leftFrame.getText();
		
		if(str1.contains("LEFT")) {
			System.out.println("The left frame has a text LEFT");
		}
		else {
			System.out.println("The left frame doesn't have text LEFT");
		}
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		
		WebElement middleFrame = driver.findElement(By.xpath("//*[@id=\"content\"]"));
		String str2 = middleFrame.getText();
		
		if(str2.contains("MIDDLE")) {
			System.out.println("The MIDDLE frame has a text MIDDLE");
		}
		else {
			System.out.println("The MIDDLE frame doesn't have text MIDDLE");
		}
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(2);
		
		WebElement rightFrame = driver.findElement(By.xpath("/html/body"));
		String str3 = rightFrame.getText();
		
		if(str3.contains("RIGHT")) {
			System.out.println("The RIGHT frame has a text RIGHT");
		}
		else {
			System.out.println("The RIGHT frame doesn't have text RIGHT");
		}
		
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		
		WebElement bottomFrame = driver.findElement(By.xpath("/html/body"));
		String str4 = bottomFrame.getText();
		
		if(str4.contains("BOTTOM")) {
			System.out.println("The BOTTOM frame has a text BOTTOM");
		}
		else {
			System.out.println("The BOTTOM frame doesn't have text BOTTOM");
		}
		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		String str5 = driver.getTitle();
		
		if(str5.contains("Frames")) {
			System.out.println("The top frame has a text 'Frames'");
		}
		else {
			System.out.println("The top frame doesn't have a text 'Frames'");
		}
		
		driver.quit();
	}

}
