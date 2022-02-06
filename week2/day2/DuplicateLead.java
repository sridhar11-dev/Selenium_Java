package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException {
//		1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
//		2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
//		3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
//		4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
//		5	Click crm/sfa link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
//		6	Click Leads link
		driver.findElement(By.partialLinkText("Leads")).click();
//		7	Click Find leads
		driver.findElement(By.partialLinkText("Find Leads")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("hari@testlesf.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		
		WebElement searchElement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String capturedName = searchElement.getText();
		System.out.println("captured Name: "+capturedName);
		
		WebElement lead1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String lead1Id = lead1.getText();
		System.out.println("leadID: "+lead1Id);
		
		lead1.click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		WebElement title = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']"));
		String expTitle = title.getText();
		String actualTitle = "Duplicate Lead";
		if(expTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("Correct Title");
		}else {
			System.out.println("Incorrect Title");
		}
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		WebElement nameElement = driver.findElement(By.id("viewLead_firstName_sp"));
		String displayedName = nameElement.getText();
		if(capturedName.equalsIgnoreCase(displayedName)) {
			System.out.println("Duplicated and captured name are same");
		}else {
			System.out.println("Duplicated and captured name are not same");
		}	
		driver.close();
	}

}
