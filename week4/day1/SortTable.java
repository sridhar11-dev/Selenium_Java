package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		WebElement elementTable = driver.findElement(By.id("table_id"));
		List<WebElement> rowList = elementTable.findElements(By.tagName("tr"));
		
		List <String> originalNameList = new ArrayList<String>();
		
		for(int i = 1; i < rowList.size(); i++) {
			List<WebElement> tableData = rowList.get(i).findElements(By.tagName("td"));
			String name = tableData.get(1).getText();
			originalNameList.add(name);
		}
		Collections.sort(originalNameList);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\src\\main\\java\\week4\\day1\\Img001.png");
		FileUtils.copyFile(source, dest);
		
		List<WebElement> headerData = rowList.get(0).findElements(By.tagName("th"));
		headerData.get(1).click();
		Thread.sleep(2000);
		
		WebElement elementTableAfterClick = driver.findElement(By.id("table_id"));
		List<WebElement> rowListAfterClick = elementTableAfterClick.findElements(By.tagName("tr"));
		List <String> nameListAfterClickAction = new ArrayList<String>();
		for(int i = 1; i < rowListAfterClick.size(); i++) {
			List<WebElement> tableData = rowListAfterClick.get(i).findElements(By.tagName("td"));
			String name = tableData.get(1).getText();
			nameListAfterClickAction.add(name);
		}
		
		if (originalNameList.equals(nameListAfterClickAction)) {
			System.out.println("Sorting functionality works. List is sorted on Click");
		}
		File source1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File(".\\src\\main\\java\\week4\\day1\\Img002.png");
		FileUtils.copyFile(source1, dest1);
		System.out.println(originalNameList);
		System.out.println(nameListAfterClickAction);
	}

}
