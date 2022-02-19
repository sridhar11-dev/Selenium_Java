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

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		Thread.sleep(2000);
		WebElement firstMobileInfo = driver.findElement(By.xpath("//div[@data-asin='B089MV3MVY']"));
		WebElement price = firstMobileInfo.findElement(By.className("a-price-whole"));
		String text = price.getText();
		WebElement star = driver.findElement(By.xpath("(//a[@role='button']/i)[2]"));
		star.click();
		Thread.sleep(2000);
		String customerRating = driver.findElement(By.xpath("(//i[@data-hook='average-stars-rating-anywhere']/following-sibling::span)[1]")).getText();
		String fifthStarPercentageRating = driver.findElement(By.xpath("(//table[@id='histogramTable']/tbody/tr[1]/td[3]/span[@class='a-size-base']/a)[1]")).getText();
		System.out.println("customerRaing: "+customerRating);
		System.out.println("5th star percentage Rating: "+fifthStarPercentageRating);
		//Doubt: how to take Rs symbol from the span tag -> getText() not retrieving symbol
		System.out.println("Price: "+text);
		driver.findElement(By.xpath("(//div[contains(@class, 's-title-instructions-style')]//a)[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		Thread.sleep(3000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\src\\main\\java\\week4\\day2\\Mobile.png");
		FileUtils.copyFile(source, dest);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(6000);
		String cartSubTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		String cartSubTotalValue = cartSubTotal.replaceAll("^\\W", "");
		String subTotalString = cartSubTotalValue.replaceAll(",", "");
		String replaceAll2 = subTotalString.replaceAll("\\.0+","");
		int subTotal = Integer.parseInt(replaceAll2);
		System.out.println("subTotal: "+subTotal);
		
		String originalPrice = text.replaceAll(",", "");
		int priceToCheck = Integer.parseInt(originalPrice);
		
		if(subTotal == priceToCheck) {
			System.out.println("Verified the subtotal: "+subTotal);
		}	
		driver.close();		
	}

}
