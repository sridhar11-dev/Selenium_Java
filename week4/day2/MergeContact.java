package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.xpath("//div[@id='left-content-column']//div[@class='frameSectionBody']//*[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']")).click();
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//tr[*]/td/input[@name='partyIdFrom']/following::img)[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		driver.manage().window().maximize();
		
		//Second Window
		System.out.println("Second Window: "+driver.getTitle());
		
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr[*]/td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a)[1]")).click();
		driver.switchTo().window(window.get(0));
		
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//tr[*]/td/input[@name='partyIdFrom']/following::img)[2]")).click();
		Set<String> newWindow = driver.getWindowHandles();
		ArrayList<String> window2 = new ArrayList<String>(newWindow);
		driver.switchTo().window(window2.get(1));
		
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr[*]/td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a)[2]")).click();
		driver.switchTo().window(window2.get(0));
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String pageTitle = driver.getTitle();
		if (pageTitle.equalsIgnoreCase("View Contact | opentaps CRM")) {
			System.out.println("Verified page title. Title is: "+pageTitle);
		}
		driver.close();
	}

}
