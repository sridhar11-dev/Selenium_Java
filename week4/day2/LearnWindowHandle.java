package week4.day2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandle {
	public static void main(String[] args) {
		int count = 0;
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		
		//using index
		driver.switchTo().window(list.get(1));
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		//using for each loop
		/***for (String string : list) {
			driver.switchTo().window(string);
			count++;
			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.equals("http://www.leafground.com/home.html")){
				break;
			}	
		}
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list.get(count-2));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle()); **/
		
		
		
	}

}
