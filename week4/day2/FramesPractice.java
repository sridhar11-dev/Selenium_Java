package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesPractice {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.tagName("input")).sendKeys("Practice Frames");
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		driver.switchTo().parentFrame(); //move one frame back
		driver.switchTo().defaultContent(); //move directly to default content
		
		driver.switchTo().frame(1);
		WebElement selectAnimal = driver.findElement(By.id("animals"));
		Select animaldd = new Select(selectAnimal);
		animaldd.selectByValue("avatar");
		driver.switchTo().defaultContent();
	}
}
