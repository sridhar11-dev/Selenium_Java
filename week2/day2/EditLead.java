package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Uma");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		WebElement lead1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String lead1Id = lead1.getText();
		System.out.println("leadID: "+lead1Id);
		lead1.click();
		
		String title = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		String actualTitle = "View Lead";
		if(title.equalsIgnoreCase(actualTitle)) {
			System.out.println("Title Matches");
		}else {
			System.out.println("Incorrect title - Title Mismatch");
		}
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys("LTI");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		WebElement updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp"));
		System.out.println("Updated company name: "+updatedCompanyName.getText());
		
		if(updatedCompanyName.isDisplayed()) {
			System.out.println("Company Name is updated");
		}else {
			System.out.println("Company Name is not updated");
		}
	}
}
