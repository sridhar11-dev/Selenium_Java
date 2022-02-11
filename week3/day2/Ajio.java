package week3.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags", Keys.ENTER);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		Thread.sleep(2000);
		String totalItems = driver.findElement(By.className("length")).getText();
		System.out.println("Total number of items : " + totalItems);
		List<WebElement> bagBrandList = driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println("Total bag Brand List size:"+bagBrandList.size());
		for (WebElement brand : bagBrandList) {
			System.out.println(brand.getText());
		}
		List<WebElement> bagNameList = driver.findElements(By.className("nameCls"));
		System.out.println("total bag name list size: "+bagNameList.size());
		System.out.println("Name of bags:");
		
		for (WebElement bagName : bagNameList) {
			System.out.println(bagName.getText());
		}
	}
}
