package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
//		/*http://leaftaps.com/opentaps/control/main
		 
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
//		8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
//		9	Enter phone number
//		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("1");
//		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1234567890");
//		10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
//		11	Capture lead ID of First Resulting lead
		WebElement lead1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String lead1Id = lead1.getText();
		System.out.println("lead: "+lead1Id);
//		12	Click First Resulting lead
		lead1.click();
//		13	Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		Thread.sleep(100);
//		14	Click Find leads
		driver.findElement(By.partialLinkText("Find Leads")).click();
//		15	Enter captured lead ID
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys(lead1Id);
//		16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement searchResult = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String expectedMsg = searchResult.getText();
		String actualMsg = "No records to display";
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Lead Id: "+ lead1Id + " is deleted successfully" );				
		}else {
			System.out.println("Lead Id: "+ lead1Id + " is not deleted successfully");
		}
//		18	Close the browser (Do not log out)
		driver.close();
	}

}
