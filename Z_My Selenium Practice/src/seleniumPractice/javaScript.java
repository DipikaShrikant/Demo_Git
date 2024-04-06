package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement from = driver.findElement(By.id("src"));
		from.sendKeys("beng");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		String city="return document.getElementById('src').value;";
		
		String citynm = (String) js.executeScript(city);
		
		while(!citynm.equalsIgnoreCase("Anand Rao Circle")) {
			Thread.sleep(2000);
			from.sendKeys(Keys.DOWN);
			 city="return document.getElementById('src').value;";
				Thread.sleep(2000);

			 citynm = (String) js.executeScript(city);
				Thread.sleep(2000);

		}
		from.sendKeys(Keys.ENTER);
		
		System.out.println(citynm);

	}

}
