package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		WebElement button = driver.findElement(By.id("btn"));
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\src\\main\\java\\week4\\day1\\originalText.png");
		FileUtils.copyFile(source, dest);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(button, "Click ME!"));
		
		File source1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File(".\\src\\main\\java\\week4\\day1\\textChange.png");
		FileUtils.copyFile(source1, dest1);
		
		button.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if(alertText.equalsIgnoreCase("Click Me!")) {
			System.out.println("verified alert text");
			System.out.println("alert text: "+ alertText);
		}
		alert.accept();
	}
}
