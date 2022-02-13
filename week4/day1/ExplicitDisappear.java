package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitDisappear {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/disapper.html");
		WebElement button = driver.findElement(By.id("btn"));
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\src\\main\\java\\week4\\day1\\ElementPresent.png");
		FileUtils.copyFile(source, dest);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(button));
		
		File source1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File(".\\src\\main\\java\\week4\\day1\\ElementDisappear.png");
		FileUtils.copyFile(source1, dest1);
		
		WebElement disappear = driver.findElement(By.xpath("//div[@id='show']/p"));
		String text = disappear.getText();
		if(text.contains("Button is disappeared")) {
			System.out.println(text+ "-" +"Verified that button is disappeared");
		}
	}

}
