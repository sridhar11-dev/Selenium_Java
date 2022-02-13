package week4.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTargetLocators {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.switchTo().frame("iframeResult");
		WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
		tryItButton.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Peter Parker");
		alert.accept();
		WebElement nameEntered = driver.findElement(By.id("demo"));
		String text = nameEntered.getText();
		if(text.contains("Peter Parker")) {
			System.out.println("Text contains Peter Parker");
		}else {
			System.out.println("Text does not contain Peter Parker");
		}
		driver.switchTo().defaultContent();
		driver.findElement(By.id("runbtn")).click();
	}

}
