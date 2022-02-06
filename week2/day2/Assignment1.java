package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Create New Account")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("firstname")).sendKeys("Sridhar");
		driver.findElement(By.name("lastname")).sendKeys("U");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following::input")).sendKeys("ABC");
		driver.findElement(By.xpath("//div[text()='New password']/following::input")).sendKeys("123");
		WebElement day = driver.findElement(By.id("day"));
		Select dayDropdown = new Select(day); 
		dayDropdown.selectByValue("11");
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("Mar");
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("1999");
		driver.findElement(By.xpath("//label[text()='Female' ]/following::input[@value=2]")).click();
	}

}
