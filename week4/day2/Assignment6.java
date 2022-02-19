package week4.day2;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		WebElement brandElement = driver.findElement(By.xpath("//div[@class='css-1yqek2e']/ul/li/a[text()='brands']"));
		Actions action = new Actions(driver);
		action.moveToElement(brandElement).perform();
		driver.findElement(By.xpath("(//div[@id='scroller-container']/div/a[contains(text(),'Oreal Paris')])[1]")).click();
		WebElement pageTitle = driver.findElement(By.id("title"));
		if(pageTitle.getText().contains("L'Oreal Paris")) {
			System.out.println("Title conatins "+pageTitle.getText());
		}
		Thread.sleep(1000);
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(1000);
		WebElement filter1 = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]"));
		String filter1Value = filter1.getText();
		if(filter1Value.equals("Shampoo")) {
			System.out.println("Filter "+filter1Value+" is selected");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='product-list-wrap']/div[1]//div//div//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
		
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> window = new ArrayList<String> (windowHandles);
		driver.switchTo().window(window.get(1));
		System.out.println(window);
		Thread.sleep(3000);
		
		WebElement selectSize = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select sizeValue = new Select(selectSize);
		sizeValue.selectByVisibleText("175ml");
		WebElement priceElement = driver.findElement(By.xpath("(//span[text()='MRP:']/following::span)[1]"));
		String price = priceElement.getText();
		System.out.println("Price MRP: "+price);
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='css-2o3va e1e0j9zy2']//div[@class='css-0 e1ewpqpu1']/button")).click();
//		WebElement grandTotalElement = driver.findElement(By.xpath("(//span[text()='Grand Total']/following::div)[1]"));
		driver.switchTo().frame(0);
		Thread.sleep(12000);
		WebElement grandTotalElement = driver.findElement(By.xpath("//span[text()='Grand Total']/following::div[@class='value']"));
		String grandTotal = grandTotalElement.getText();
		System.out.println("Grand Total: "+grandTotal);
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[@class='guest-txt ptb10']/following-sibling::button")).click();
		WebElement priceCheck = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div[@class='value']"));
		if(priceCheck.getText().equals(grandTotal)) {
			System.out.println("Price is same grand Total. Price: "+priceCheck.getText());
		}
	}
}
