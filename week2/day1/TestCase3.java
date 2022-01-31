package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.xpath("//input[contains(@id, 'username')]")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class, 'decorativeSubmit')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sridhar");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("U");
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sourceOption = new Select(source);
		sourceOption.selectByVisibleText("Employee");
		WebElement marketingCampaign = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select marketingCampaignOption = new Select(marketingCampaign);
		marketingCampaignOption.selectByValue("LEAD_CONFERENCE");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Sridhar");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("U");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mr");
    	driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("11/05/1999");
    	driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Test");
    	driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Test");
    	driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("100000");
    	Select currencyUomId = new Select(driver.findElement(By.id("createLeadForm_currencyUomId")));
    	currencyUomId.selectByIndex(2);
    	Select industryEnumId = new Select(driver.findElement(By.id("createLeadForm_industryEnumId")));  
    	industryEnumId.selectByIndex(1);
    	driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("400");
    	Select ownershipEnumId = new Select(driver.findElement(By.id("createLeadForm_ownershipEnumId")));  
        ownershipEnumId.selectByIndex(1);
    
    	driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("47568");
    	driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("ABC");
    	driver.findElement(By.id("createLeadForm_description")).sendKeys("This is a Test Description");
    	driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("This is a Important Note");
    	
    	//Contact Information
    	
    	driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
    	driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("14");
    	driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9876543210");
    	driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("412");
    	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sridhar@gmail.com");
    	driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.seleniumpracticetests.com");
    	
    	//Primary Address   
    	driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Sridhar");
    	driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Sridhar");
    	driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("UK");
    	driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Bakers street");
    	driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("London");
    	Select generalStateProvinceGeoId = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));  
    	generalStateProvinceGeoId.selectByIndex(9);
    	driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("100");
    	driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("865");
    	Select generalCountryGeoId = new Select(driver.findElement(By.id("createLeadForm_generalCountryGeoId")));  
    	generalCountryGeoId.selectByValue("GBR");
    	
    	driver.findElement(By.name("submitButton")).click();
        driver.close(); 
	}

}
