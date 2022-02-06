package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
		Point location = driver.findElement(By.id("position")).getLocation();
		int x = driver.findElement(By.id("position")).getLocation().getX();
		int y = driver.findElement(By.id("position")).getLocation().getY();
		System.out.println("element location: "+location);
		System.out.println("element xcord location: "+x);
		System.out.println("element ycord location: "+y);
		WebElement elementColor = driver.findElement(By.id("color"));
		String cssValue = elementColor.getCssValue("background-color");
		System.out.println("Element Color:"+cssValue);
		WebElement elementSize = driver.findElement(By.id("size"));
		Dimension size = elementSize.getSize();
		System.out.println("Element size:" + size);
		int width = elementSize.getSize().getWidth();
		System.out.println("Element width:" + width);
		int height = elementSize.getSize().getHeight();
		System.out.println("Element Height:" + height);
	}

}
