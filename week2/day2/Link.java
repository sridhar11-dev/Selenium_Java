package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		WebElement elementNavigationPageWithoutClick = driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']"));
		String navigateLocation = elementNavigationPageWithoutClick.getAttribute("href");
		System.out.println("Find where am supposed to go without clicking me? goes to: "+navigateLocation);
		
		WebElement brokenElement = driver.findElement(By.xpath("//a[text()='Verify am I broken?']"));
		String brokenUrl = brokenElement.getAttribute("href");
		System.out.println(brokenUrl);
//		brokenElement.click();
//		String errorCode = driver.findElement(By.tagName("h1")).getText();
		if(brokenUrl.contains("error")) {
			System.out.println("Broken link with url: "+brokenUrl);
		}
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links: "+links.size());
		
		
	}

}
