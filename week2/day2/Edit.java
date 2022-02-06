package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		WebElement appendText = driver.findElement(By.xpath("//input[contains(@value,'Append')]"));
		appendText.sendKeys("Test");
		appendText.sendKeys("leaf");
		String appendedText = appendText.getAttribute("value");
		appendText.sendKeys(Keys.TAB);
		System.out.println("Appended Text: "+appendedText);
		WebElement element = driver.findElement(By.xpath("//input[@disabled='true']"));
		if(element.isEnabled()) {
			System.out.println("Element is editable");
		}else {
			System.out.println("Element is not editable");
		}
	}
}
