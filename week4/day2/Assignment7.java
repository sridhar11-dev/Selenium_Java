package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		WebElement mensFashion = driver.findElement(By.xpath("//span[contains(text(), \"Men's Fashion\")]"));
		Actions action = new Actions(driver);
		action.moveToElement(mensFashion).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		Thread.sleep(2000);
		String totalItems = driver.findElement(By.xpath("//h1/following-sibling::span")).getText();
		System.out.println(totalItems);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("sort-label")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']/li)[2]")).click();
		Thread.sleep(3000);
		List<WebElement> priceElements = driver.findElements(By.xpath("//span[contains(@id, 'display-price')]"));
		ArrayList<Integer> priceDisplayed = new ArrayList<Integer>();
		for (WebElement element : priceElements) {
			String price = element.getText().replaceAll("Rs. ", "");
			String replacedPrice = price.replaceAll(",", "");
			int priceValue = Integer.parseInt(replacedPrice);
			priceDisplayed.add(priceValue);
		}

		ArrayList<Integer> priceToCheck = new ArrayList<Integer>(priceDisplayed);
		Collections.sort(priceToCheck);
		if(priceToCheck.equals(priceDisplayed)) {
			System.out.println("Items displayed are sorted correctly");
		}
		
		WebElement fromVal = driver.findElement(By.xpath("//div[@class='price-text-box']/input[@name='fromVal']"));
		fromVal.clear();
		fromVal.sendKeys("900");
		WebElement toVal = driver.findElement(By.xpath("//div[@class='price-text-box']/input[@name='toVal']"));
		toVal.clear();
		toVal.sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-input']/following-sibling::div[contains(text(), 'GO')]")).click();
		Thread.sleep(2000);
		WebElement colorElement = driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", fromVal);
		Thread.sleep(2000);
		colorElement.click();
		
		WebElement shoeTitle = driver.findElement(By.xpath("//h1[contains(text(),'Training Shoes')]"));
		js.executeScript("arguments[0].scrollIntoView();", shoeTitle);
		Thread.sleep(6000);
		
		String priceFilter = driver.findElement(By.xpath("(//div[@class='navFiltersPill']/a[@class='clear-filter-pill'])[1]")).getText();
		WebElement colorFilterElement = driver.findElement(By.xpath("(//div[@class='navFiltersPill']/a)[2]"));
		String colorFilter = colorFilterElement.getText();
		System.out.println(colorFilter);
		if((priceFilter.equals("Rs. 900 - Rs. 1200")) && (colorFilter.equals("Navy"))){
			System.out.println("Price Filter: "+priceFilter+" and color Filter: "+colorFilter+" applied");
		}
		WebElement firstElement = driver.findElement(By.xpath("(//source[@class='product-image']/following-sibling::img)[1]"));
		action.moveToElement(firstElement).perform();
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		Thread.sleep(2000);
		String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("cost:"+cost+" discount: "+discount);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\src\\main\\java\\week4\\day2\\shoes.png");
		FileUtils.copyFile(source, dest);
		
		driver.findElement(By.xpath("//div[@class='sidebarin comp-qv']/div[contains(@class,'close')]/i")).click();
		
		driver.close();
		driver.quit();
	}

}
