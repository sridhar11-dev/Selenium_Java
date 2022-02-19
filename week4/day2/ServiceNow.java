package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev98530.service-now.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Moonknight1199#");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("//ul[@aria-label='Modules for Application: Incident']/li//div/a//div[text()='All']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		driver.switchTo().defaultContent();
		
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList <String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("//table[@id='sys_user_table']//tbody/tr[@id='row_sys_user_a8f98bb0eb32010045e1a5115206fe3a']//td/a")).click();
		driver.switchTo().window(window.get(0));
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Incident created for Testing - This is short description");
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_insert")).click();
		driver.findElement(By.xpath("//div[@id='list_nav_incident']//span[@id='incident_hide_search']//div[@class='input-group']/input")).sendKeys(incidentNumber, Keys.ENTER);
		WebElement incidentCreated = driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr[*]/td[3]/a"));
		if(incidentNumber.equals(incidentCreated.getText())) {
			System.out.println("Verified Incident is created and Incident Number:"+incidentCreated.getText());
		}
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\src\\main\\java\\week4\\day2\\serviceNow.png");
		FileUtils.copyFile(source, dest);
		
	}

}
