package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/selectable/");
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[1]"));
		WebElement element2 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[2]"));
		WebElement element3 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[3]"));
		WebElement element4 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[4]"));
		WebElement element5 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[5]"));
		builder.keyDown(Keys.CONTROL).click(element1).click(element2).click(element3).click(element4).click(element5).keyUp(Keys.CONTROL).perform();
	}
}
