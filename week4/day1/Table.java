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

public class Table {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement elementTable = driver.findElement(By.id("table_id"));
		List<WebElement> rowList = elementTable.findElements(By.tagName("tr"));
		
		List<WebElement> tableHeaders = rowList.get(0).findElements(By.tagName("th"));
		System.out.println("Number of columns: "+tableHeaders.size());
		
		System.out.println("Number of rows: "+rowList.size());
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\src\\main\\java\\week4\\day1\\Table1.png");
		FileUtils.copyFile(source, dest);
		
		List<WebElement> learnToInteractElementsData = rowList.get(2).findElements(By.tagName("td"));
		String progressData = learnToInteractElementsData.get(1).getText();
		System.out.println("The progress value for Learn to Interact with elemets: "+progressData);

		List <Integer> progressList = new ArrayList<Integer>();
		
		//convert progress to int and add to list
		for(int i = 1; i < rowList.size(); i++) {
			List<WebElement> tableData = rowList.get(i).findElements(By.tagName("td"));
			String progress = tableData.get(1).getText();
			String dataToConvert = progress.replaceAll("%", "");
			int parseInt = Integer.parseInt(dataToConvert);
			progressList.add(parseInt);
		}
		//find min value
		Integer min = Collections.min(progressList);
		
		//find index of the value
		int indexOf = progressList.indexOf(min);
		int index = indexOf + 1;
		System.out.println(index);
		
		//check the inputbox for the min value row
		List<WebElement> elementToCheck = rowList.get(index).findElements(By.tagName("td"));
		elementToCheck.get(2).findElement(By.name("vital")).click();
		
		File source1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File(".\\src\\main\\java\\week4\\day1\\TableAfterCheckBoxClick.png");
		FileUtils.copyFile(source1, dest1);
	}

}