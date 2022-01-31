package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAssignments {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// to get the path where webdriver.chrome.driver is placed
		//System.out.println(System.getProperty("webdriver.chrome.driver"));
		// 1. Login to leaftaps application using "DemoCSR" & "crmsfa"
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// 2. Click on "CRM/SFA" link link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		// 3. Click on Leads
		driver.findElement(By.partialLinkText("Leads")).click();
		
		// 4. Click on Create Lead link
		driver.findElement(By.partialLinkText("Create Lead")).click();

		// 5. Select "Employee" from Source drop down using Visible Text
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sourceOption = new Select(source);
		sourceOption.selectByVisibleText("Employee");

		// 6. Select "Finance" from Industry drop down using Value
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industryOption = new Select(industry);
		industryOption.selectByValue("IND_FINANCE");

		// 7. Select "Partnership" from Ownership drop down using Index
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownershipOption = new Select(ownership);
		ownershipOption.selectByIndex(2);
	}

}
