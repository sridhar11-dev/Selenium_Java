package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		driver.switchTo().frame(0);
		WebElement Frame1ClickMe = driver.findElement(By.id("Click"));
		File source1 = Frame1ClickMe.getScreenshotAs(OutputType.FILE);
		File dest1 = new File(".\\src\\main\\java\\week4\\day2\\clickMe_frame1.png");
		FileUtils.copyFile(source1, dest1);
		driver.switchTo().defaultContent();
		List<WebElement> numberOfFramesUsingTagName = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of Frames: "+numberOfFramesUsingTagName.size());
	}

}
