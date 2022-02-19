package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[1]"));
		WebElement element2 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[2]"));
		WebElement element3 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[3]"));
		WebElement element4 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[4]"));
		WebElement element5 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[5]"));
		builder.dragAndDropBy(element2, 0, 100).perform();
		builder.dragAndDrop(element4, element1).perform();
	}

}
