package week4.day1;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("TPJ", Keys.TAB);
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU", Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(2000);
		WebElement elementTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		List<WebElement> listRows = elementTable.findElements(By.tagName("tr"));
		
		for(int i = 0; i<listRows.size(); i++) {
			WebElement currentRow = listRows.get(i);
			List<WebElement> listColumns = currentRow.findElements(By.tagName("td"));
			String trainName = listColumns.get(1).getText();
			if(trainName.contains("SF")) {
				String trainId = listColumns.get(0).getText();
				System.out.println("TrainName: "+trainName+ " "+"TrainId: "+trainId);
			}
//			for(int j =0; j < listColumns.size(); j++) {
//				WebElement currentColumnTrainNameElement = listColumns.get(j);
//				String trainName = currentColumnTrainNameElement.getText();
//				System.out.println(trainName);
//			}
		}
	}
}
