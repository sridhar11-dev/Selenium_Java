package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		WebElement isElementChecked = driver.findElement(By.xpath("//div[text()='Selenium']/input"));
		if(isElementChecked.isSelected()) {
			System.out.println("Element is selected");
		}else {
			System.out.println("Element not selected");
		}
		
		WebElement javaLang = driver.findElement(By.xpath("//div[text()='Java']/input"));
		WebElement sqlLang = driver.findElement(By.xpath("//div[text()='SQL']/input"));
		WebElement cLang = driver.findElement(By.xpath("//div[text()='C']/input"));
		WebElement cppLang = driver.findElement(By.xpath("//div[text()='C++']/input"));
		javaLang.click();
		sqlLang.click();
		cLang.click();
		cppLang.click();
		
		WebElement box1 = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[1]"));
		WebElement box2 = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[2]"));
		
		if(box1.isSelected()) {
			box1.click();
		}
		if (box2.isSelected()) {
			box2.click();
		}
		
		driver.findElement(By.xpath("//label[contains(text(), 'Select all below checkboxes')]/following::input[1]")).click();
		driver.findElement(By.xpath("//label[contains(text(), 'Select all below checkboxes')]/following::input[2]")).click();
		driver.findElement(By.xpath("//label[contains(text(), 'Select all below checkboxes')]/following::input[3]")).click();
		driver.findElement(By.xpath("//label[contains(text(), 'Select all below checkboxes')]/following::input[4]")).click();
		driver.findElement(By.xpath("//label[contains(text(), 'Select all below checkboxes')]/following::input[5]")).click();
		
	}

}
