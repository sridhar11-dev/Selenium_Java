package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		WebElement trainingProgramdd1 = driver.findElement(By.id("dropdown1"));
		Select programdd1 = new Select(trainingProgramdd1);
		programdd1.selectByIndex(1);
		
		WebElement trainingProgramdd2 = driver.findElement(By.name("dropdown2"));
		Select programdd2 = new Select(trainingProgramdd2);
		programdd2.selectByVisibleText("UFT/QTP");
		
		WebElement trainingProgramdd3 = driver.findElement(By.id("dropdown3"));
		Select programdd3 = new Select(trainingProgramdd3);
		programdd3.selectByValue("4");
		
//		Get no of dropdown options - doubt need to check
		
		WebElement elementByKeys = driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/parent::select"));
		elementByKeys.sendKeys("Loadrunner");
		
		WebElement multipleSelect = driver.findElement(By.xpath("//option[text()='Select your programs']/..")); //equivalent to parent::select
		Select multiplePrograms = new Select(multipleSelect);
		multiplePrograms.selectByIndex(1);
		multiplePrograms.selectByIndex(2);
		multiplePrograms.selectByIndex(3);	
	}

}
