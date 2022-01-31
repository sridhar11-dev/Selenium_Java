package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomAssignmentXpath {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.xpath("//input[contains(@id, 'username')]")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class, 'decorativeSubmit')]")).click();
		
		// 2. Click on "CRM/SFA" link link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		// 3. Click on Leads
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		
		// 4. Click on Create Lead link
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		driver.findElement(By.xpath("//input[contains(@id, 'createLeadForm_companyName')]")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[contains(@id, 'createLeadForm_lastName')]")).sendKeys("U");
		driver.findElement(By.xpath("//input[contains(@id, 'createLeadForm_firstName')]")).sendKeys("Sridhar");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		//links for applications to automate:
		//https://dev83272.service-now.com/ admin India@123 https://login.salesforce.com/ hari.radhakrishnan@qeagle.com Password@123
	}

}
